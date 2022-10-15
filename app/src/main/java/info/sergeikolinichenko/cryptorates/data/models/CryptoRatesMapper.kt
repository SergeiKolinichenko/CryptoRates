package info.sergeikolinichenko.cryptorates.data.models

import info.sergeikolinichenko.cryptorates.domain.models.CoinInfo

/** Created by Sergei Kolinichenko on 14.10.2022 at 20:56 (GMT+3) **/

class CryptoRatesMapper {
    fun mapCoinInfoToData(coinInfo: CoinInfo) = CoinInfoDto(
        id = coinInfo.id
    )
    fun mapDataToCoinInfo(coinInfoData: CoinInfoDto) = CoinInfo(
        id = coinInfoData.id
    )
}