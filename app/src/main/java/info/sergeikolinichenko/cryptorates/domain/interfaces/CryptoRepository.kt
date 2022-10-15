package info.sergeikolinichenko.cryptorates.domain.interfaces

import androidx.lifecycle.LiveData
import info.sergeikolinichenko.cryptorates.domain.models.CoinInfo
import info.sergeikolinichenko.cryptorates.domain.models.CoinInfoList

/** Created by Sergei Kolinichenko on 14.10.2022 at 17:51 (GMT+3) **/

interface CryptoRepository {

    fun getCoinInfoList(): LiveData<List<CoinInfo>>
    fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo>
    fun loadData()
}