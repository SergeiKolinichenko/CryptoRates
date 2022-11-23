package info.sergeikolinichenko.cryptorates.domain.usecases

import info.sergeikolinichenko.cryptorates.domain.CryptoRepository
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 15.10.2022 at 16:42 (GMT+3) **/

class LoadCryptoDataUseCase @Inject constructor(
    private val repository: CryptoRepository
) {

    operator fun invoke() = repository.loadCryptoData()

}