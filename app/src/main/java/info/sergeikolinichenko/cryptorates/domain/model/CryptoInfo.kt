package info.sergeikolinichenko.cryptorates.domain.model

/** Created by Sergei Kolinichenko on 14.10.2022 at 15:13 (GMT+3) **/

data class CryptoInfo(
    val fromSymbol: String,
    val toSymbol: String?,
    val price: String?,
    val lastUpdate: String?,
    val highDay: String?,
    val lowDay: String?,
    val lastMarket: String?,
    val imageUrl: String?
)
