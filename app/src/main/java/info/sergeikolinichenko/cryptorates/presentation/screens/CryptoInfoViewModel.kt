package info.sergeikolinichenko.cryptorates.presentation.screens

import androidx.lifecycle.ViewModel
import info.sergeikolinichenko.cryptorates.domain.usecases.GetCryptoInfoUseCase
import info.sergeikolinichenko.cryptorates.domain.usecases.GetCryptoListUseCase
import info.sergeikolinichenko.cryptorates.domain.usecases.LoadCryptoDataUseCase
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 02.11.2022 at 19:37 (GMT+3) **/

class CryptoInfoViewModel @Inject constructor(
    getCryptoListUseCase: GetCryptoListUseCase,
    private val getCryptoInfoUseCase: GetCryptoInfoUseCase,
    loadDataUseCase: LoadCryptoDataUseCase
) : ViewModel() {
    val cryptoInfoList = getCryptoListUseCase()

    init {
        loadDataUseCase()
    }

    fun getDetailInfo(fSym: String) = getCryptoInfoUseCase(fSym)
}
