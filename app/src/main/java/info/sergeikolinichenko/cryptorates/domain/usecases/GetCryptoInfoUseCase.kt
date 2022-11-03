package info.sergeikolinichenko.cryptorates.domain.usecases

import info.sergeikolinichenko.cryptorates.domain.CryptoRepository

/** Created by Sergei Kolinichenko on 15.10.2022 at 16:41 (GMT+3) **/

class GetCryptoInfoUseCase(
    private val repository: CryptoRepository
) {

    operator fun invoke(fromSymbol: String) = repository.getCryptoInfo(fromSymbol)
}