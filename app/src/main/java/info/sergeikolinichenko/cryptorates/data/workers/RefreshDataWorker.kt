package info.sergeikolinichenko.cryptorates.data.workers

import android.content.Context
import android.util.Log
import androidx.work.*
import info.sergeikolinichenko.cryptorates.data.CryptoMapper
import info.sergeikolinichenko.cryptorates.data.database.CryptoInfoDao
import info.sergeikolinichenko.cryptorates.data.network.ApiService
import info.sergeikolinichenko.cryptorates.data.repository.CryptoRepositoryImpl
import info.sergeikolinichenko.cryptorates.di.ChildWorkerFactory
import kotlinx.coroutines.delay
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 21.11.2022 at 22:08 (GMT+3) **/

class RefreshDataWorker(
    context: Context,
    workerParameters: WorkerParameters,
    private val cryptoInfoDao: CryptoInfoDao,
    private val apiService: ApiService,
    private val mapper: CryptoMapper
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {
        while (true) {
            try {
                val topCoins =
                    apiService.getTopCryptoInfo(limit = CryptoRepositoryImpl.LIMIT_TOP_COINS)
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

    class Factory @Inject constructor(
        private val cryptoInfoDao: CryptoInfoDao,
        private val apiService: ApiService,
        private val mapper: CryptoMapper
    ): ChildWorkerFactory {
        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return RefreshDataWorker(
                context, workerParameters, cryptoInfoDao, apiService, mapper
            )
        }

    }
}