package info.sergeikolinichenko.cryptorates.domain.models

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Created by Sergei Kolinichenko on 14.10.2022 at 18:15 (GMT+3) **/

data class CoinPriceInfoRow(
    @SerializedName("RAW")
    @Expose
    val coinPriceInfoJsonObject: JsonObject? = null
)
