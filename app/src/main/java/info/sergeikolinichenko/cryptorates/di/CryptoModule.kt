package info.sergeikolinichenko.cryptorates.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import info.sergeikolinichenko.cryptorates.data.database.AppDatabase
import info.sergeikolinichenko.cryptorates.data.database.CryptoInfoDao
import info.sergeikolinichenko.cryptorates.data.network.ApiFactory
import info.sergeikolinichenko.cryptorates.data.network.ApiService
import info.sergeikolinichenko.cryptorates.data.repository.CryptoRepositoryImpl
import info.sergeikolinichenko.cryptorates.domain.CryptoRepository

/** Created by Sergei Kolinichenko on 23.11.2022 at 19:46 (GMT+3) **/

@Module
interface CryptoModule {

    @Binds
    @ApplicationScope
    fun bindCryptoRepository(impl: CryptoRepositoryImpl): CryptoRepository

    companion object{

        @Provides
        @ApplicationScope
        fun provideCryptoInfoDao( application: Application ): CryptoInfoDao {
            return AppDatabase.getInstance(application).cryptoInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}