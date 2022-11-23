package info.sergeikolinichenko.cryptorates.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import info.sergeikolinichenko.cryptorates.data.database.AppDatabase
import info.sergeikolinichenko.cryptorates.data.CryptoMapper
import info.sergeikolinichenko.cryptorates.data.network.ApiFactory
import info.sergeikolinichenko.cryptorates.data.workers.RefreshDataWorker
import info.sergeikolinichenko.cryptorates.domain.CryptoRepository
import info.sergeikolinichenko.cryptorates.domain.model.CryptoInfo
import kotlinx.coroutines.delay

/** Created by Sergei Kolinichenko on 02.11.2022 at 19:45 (GMT+3) **/

class CryptoRepositoryImpl(private val application: Application): CryptoRepository {

    private val cryptoInfoDao = AppDatabase.getInstance(application).cryptoInfoDao()
    private val mapper = CryptoMapper()

    override fun getCryptoInfoList(): LiveData<List<CryptoInfo>> {
        return Transformations.map(
            cryptoInfoDao.getPriceList()
        ) { it ->
            it.map {
            mapper.mapDbModelToEntity(it)
        }}
    }

    override fun getCryptoInfo(fromSymbol: String): LiveData<CryptoInfo> {
        return Transformations.map(
            cryptoInfoDao.getPriceInfoAboutCoin(fromSymbol)
        ){
            mapper.mapDbModelToEntity(it)
        }
    }

    override fun loadCryptoData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.WORKER_NAME,
            ExistingWorkPolicy.KEEP,
            RefreshDataWorker.makeRequest()
        )
    }

    companion object {
        const val LIMIT_TOP_COINS = 50
    }
}