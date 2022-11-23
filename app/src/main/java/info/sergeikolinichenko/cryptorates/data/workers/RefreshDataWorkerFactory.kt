package info.sergeikolinichenko.cryptorates.data.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import info.sergeikolinichenko.cryptorates.data.CryptoMapper
import info.sergeikolinichenko.cryptorates.data.database.CryptoInfoDao
import info.sergeikolinichenko.cryptorates.data.network.ApiService

/** Created by Sergei Kolinichenko on 23.11.2022 at 20:52 (GMT+3) **/

class RefreshDataWorkerFactory(
    private val cryptoInfoDao: CryptoInfoDao,
    private val apiService: ApiService,
    private val mapper: CryptoMapper
) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return RefreshDataWorker(
            appContext,
            workerParameters,
            cryptoInfoDao,
            apiService,
            mapper
        )
    }
}