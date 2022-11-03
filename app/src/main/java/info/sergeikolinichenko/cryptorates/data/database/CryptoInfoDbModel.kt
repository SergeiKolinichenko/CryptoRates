package info.sergeikolinichenko.cryptorates.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/** Created by Sergei Kolinichenko on 02.11.2022 at 20:31 (GMT+3) **/

@Entity(tableName = "full_price_list")
data class CryptoInfoDbModel(
    @PrimaryKey
    val fromSymbol: String,
    val toSymbol: String?,
    val price: String?,
    val lastUpdate: Long?,
    val highDay: String?,
    val lowDay: String?,
    val lastMarket: String?,
    val imageUrl: String?
)
