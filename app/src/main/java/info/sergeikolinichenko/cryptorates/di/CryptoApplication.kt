package info.sergeikolinichenko.cryptorates.di

import android.app.Application
import androidx.work.Configuration
import info.sergeikolinichenko.cryptorates.data.workers.RefreshDataWorkerFactory
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 23.11.2022 at 20:00 (GMT+3) **/

class CryptoApplication : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: RefreshDataWorkerFactory

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder().setWorkerFactory(workerFactory).build()
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}