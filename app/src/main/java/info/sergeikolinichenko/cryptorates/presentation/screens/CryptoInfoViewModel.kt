package info.sergeikolinichenko.cryptorates.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import info.sergeikolinichenko.cryptorates.domain.usecases.GetCryptoInfoUseCase
import info.sergeikolinichenko.cryptorates.domain.usecases.GetCryptoListUseCase
import info.sergeikolinichenko.cryptorates.domain.usecases.LoadCryptoDataUseCase
import kotlinx.coroutines.launch

/** Created by Sergei Kolinichenko on 02.11.2022 at 19:37 (GMT+3) **/

class CryptoInfoViewModel(
    getCryptoListUseCase: GetCryptoListUseCase,
    private val getCryptoInfoUseCase: GetCryptoInfoUseCase,
    private val loadDataUseCase: LoadCryptoDataUseCase
): ViewModel()
{
    val cryptoInfoList = getCryptoListUseCase()

    init {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }

    fun getDetailInfo(fSym: String) = getCryptoInfoUseCase(fSym)
}
