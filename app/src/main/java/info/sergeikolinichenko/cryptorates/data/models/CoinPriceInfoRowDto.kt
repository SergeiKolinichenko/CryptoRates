package info.sergeikolinichenko.cryptorates.data.models

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Created by Sergei Kolinichenko on 14.10.2022 at 20:43 (GMT+3) **/

data class CoinPriceInfoRowDto(
    @SerializedName("RAW")
    @Expose
    val coinPriceInfoJsonObject: JsonObject? = null
)
