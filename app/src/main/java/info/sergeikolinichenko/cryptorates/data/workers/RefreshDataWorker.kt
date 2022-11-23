package info.sergeikolinichenko.cryptorates.data.workers

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import info.sergeikolinichenko.cryptorates.data.CryptoMapper
import info.sergeikolinichenko.cryptorates.data.database.AppDatabase
import info.sergeikolinichenko.cryptorates.data.network.ApiFactory
import info.sergeikolinichenko.cryptorates.data.repository.CryptoRepositoryImpl
import kotlinx.coroutines.delay

/** Created by Sergei Kolinichenko on 21.11.2022 at 22:08 (GMT+3) **/

class RefreshDataWorker(
    context: Context,
    workerParameters: WorkerParameters
): CoroutineWorker(context, workerParameters) {

    private val cryptoInfoDao = AppDatabase.getInstance(context).cryptoInfoDao()
    private val apiService = ApiFactory.apiService
    private val mapper = CryptoMapper()

    override suspend fun doWork(): Result {
        while (true) {
            try {
                val topCoins = apiService.getTopCryptoInfo(limit = CryptoRepositoryImpl.LIMIT_TOP_COINS)
                val fSyms = mapper.mapNamesListToString(topCoins)
                val jsonContainer = apiService.getFullPriceList(fSyms = fSyms)
                val coinInfoDtoList = mapper.mapJsonContainerToListCryptoInfo(jsonContainer)
                val dbModelList = coinInfoDtoList.map { mapper.mapDtoToDbModel(it) }
                cryptoInfoDao.insertPriceList(dbModelList)
            } catch (e: Exception) {
                Log.ERROR
            }
            delay(RECEIVE_DELAY_JSON)
        }
    }

    companion object {
        private const val RECEIVE_DELAY_JSON = 10000L
        const val WORKER_NAME = "RefreshDataWorker"

        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<RefreshDataWorker>().build()
        }
    }
}