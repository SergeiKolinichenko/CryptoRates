package info.sergeikolinichenko.cryptorates.presentation.screens

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import info.sergeikolinichenko.cryptorates.data.repository.CryptoRepositoryImpl
import info.sergeikolinichenko.cryptorates.domain.usecases.GetCryptoInfoUseCase
import info.sergeikolinichenko.cryptorates.domain.usecases.GetCryptoListUseCase
import info.sergeikolinichenko.cryptorates.domain.usecases.LoadCryptoDataUseCase

/** Created by Sergei Kolinichenko on 02.11.2022 at 19:38 (GMT+3) **/

class CryptoInfoViewModelFactory(application: Application): ViewModelProvider.Factory {

    private val repository = CryptoRepositoryImpl(application)

    private val getCryptoListUseCase = GetCryptoListUseCase(repository)
    private val getCryptoInfoUseCase = GetCryptoInfoUseCase(repository)
    private val loadDataUseCase = LoadCryptoDataUseCase(repository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(CryptoInfoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            CryptoInfoViewModel(
                getCryptoListUseCase,
                getCryptoInfoUseCase,
                loadDataUseCase
            ) as T
        } else {
            throw RuntimeException("Unknown view Model class $modelClass")
        }
    }
}