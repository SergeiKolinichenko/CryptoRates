package info.sergeikolinichenko.cryptorates.data.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import info.sergeikolinichenko.cryptorates.di.ChildWorkerFactory
import javax.inject.Inject
import javax.inject.Provider

/** Created by Sergei Kolinichenko on 23.11.2022 at 20:52 (GMT+3) **/

class CryptoWorkerFactory @Inject constructor(
    private val workerProvides:
            @JvmSuppressWildcards Map<Class<out ListenableWorker>, Provider<ChildWorkerFactory>>
) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when(workerClassName) {
            RefreshDataWorker::class.qualifiedName -> {
                val childWorkerFactory = workerProvides[RefreshDataWorker::class.java]?.get()
                return childWorkerFactory?.create(appContext, workerParameters)
            }
            else -> null
        }
    }
}