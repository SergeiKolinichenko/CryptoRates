package info.sergeikolinichenko.cryptorates.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import info.sergeikolinichenko.cryptorates.data.workers.RefreshDataWorker

/** Created by Sergei Kolinichenko on 25.11.2022 at 17:25 (GMT+3) **/

@Module
interface WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(RefreshDataWorker::class)
    fun bindsRefreshDataWorkerFactory(worker: RefreshDataWorker.Factory): ChildWorkerFactory
}