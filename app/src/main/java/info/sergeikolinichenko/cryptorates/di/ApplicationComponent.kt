package info.sergeikolinichenko.cryptorates.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import info.sergeikolinichenko.cryptorates.presentation.screens.CryptoDetailActivity
import info.sergeikolinichenko.cryptorates.presentation.screens.CryptoPriceListActivity

/** Created by Sergei Kolinichenko on 23.11.2022 at 19:56 (GMT+3) **/

@ApplicationScope
@Component(
    modules = [
        CryptoModule::class,
        ViewModelsModule::class,
        WorkerModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: CryptoPriceListActivity)
    fun inject(activity: CryptoDetailActivity)
    fun inject(application: CryptoApplication)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}