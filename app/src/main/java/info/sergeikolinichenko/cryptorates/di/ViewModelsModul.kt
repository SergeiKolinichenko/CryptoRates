package info.sergeikolinichenko.cryptorates.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import info.sergeikolinichenko.cryptorates.presentation.screens.CryptoInfoViewModel

/** Created by Sergei Kolinichenko on 23.11.2022 at 20:13 (GMT+3) **/

@Module
interface ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(CryptoInfoViewModel::class)
    fun bindCryptoViewModel(viewModel: CryptoInfoViewModel): ViewModel
}