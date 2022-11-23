package info.sergeikolinichenko.cryptorates.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import info.sergeikolinichenko.cryptorates.domain.usecases.GetCryptoInfoUseCase
import info.sergeikolinichenko.cryptorates.domain.usecases.GetCryptoListUseCase
import info.sergeikolinichenko.cryptorates.domain.usecases.LoadCryptoDataUseCase
import javax.inject.Inject
import javax.inject.Provider

/** Created by Sergei Kolinichenko on 02.11.2022 at 19:38 (GMT+3) **/

class CryptoInfoViewModelFactory @Inject constructor(
    private val viewModelProviders:
    @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelProviders[modelClass]?.get() as T
    }
}