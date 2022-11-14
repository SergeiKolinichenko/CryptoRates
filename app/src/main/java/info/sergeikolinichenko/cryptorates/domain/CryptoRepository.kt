package info.sergeikolinichenko.cryptorates.domain

import androidx.lifecycle.LiveData
import info.sergeikolinichenko.cryptorates.domain.model.CryptoInfo

/** Created by Sergei Kolinichenko on 14.10.2022 at 17:51 (GMT+3) **/

interface CryptoRepository {

    fun getCryptoInfoList(): LiveData<List<CryptoInfo>>
    fun getCryptoInfo(fromSymbol: String): LiveData<CryptoInfo>
    suspend fun loadCryptoData()
}