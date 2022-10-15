package info.sergeikolinichenko.cryptorates.domain.usecases

import info.sergeikolinichenko.cryptorates.domain.interfaces.CryptoRepository

/** Created by Sergei Kolinichenko on 15.10.2022 at 16:42 (GMT+3) **/

class LoadDataUseCase(
    private val repository: CryptoRepository
) {

    operator fun invoke() = repository.loadData()

}