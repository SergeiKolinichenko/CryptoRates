package info.sergeikolinichenko.cryptorates.di

import android.app.Application
import androidx.work.Configuration
import info.sergeikolinichenko.cryptorates.data.CryptoMapper
import info.sergeikolinichenko.cryptorates.data.database.AppDatabase
import info.sergeikolinichenko.cryptorates.data.network.ApiFactory
import info.sergeikolinichenko.cryptorates.data.workers.RefreshDataWorkerFactory

/** Created by Sergei Kolinichenko on 23.11.2022 at 20:00 (GMT+3) **/

class CryptoApplication : Application(), Configuration.Provider {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder().setWorkerFactory(
            RefreshDataWorkerFactory(
                AppDatabase.getInstance(this).cryptoInfoDao(),
                ApiFactory.apiService,
                CryptoMapper()
            )
        )
            .build()
    }
}