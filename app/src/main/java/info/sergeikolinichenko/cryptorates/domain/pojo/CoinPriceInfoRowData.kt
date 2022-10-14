package info.sergeikolinichenko.cryptorates.domain.pojo

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Created by Sergei Kolinichenko on 10.2022 at 18:15 (GMT+3) **/

data class CoinPriceInfoRowData(
    @SerializedName("RAW")
    @Expose
    val coinPriceInfoJsonObject: JsonObject? = null
)
