package info.sergeikolinichenko.cryptorates.domain.interfaces

import info.sergeikolinichenko.cryptorates.domain.pojo.CoinInfo
import info.sergeikolinichenko.cryptorates.domain.pojo.CoinInfoListOfData

/** Created by Sergei Kolinichenko on 10.2022 at 17:51 (GMT+3) **/

interface CoinRatesRepository {

    fun getCoinInfoList(): List<CoinInfoListOfData>
    fun getCoinInfo(id: String): CoinInfo
}