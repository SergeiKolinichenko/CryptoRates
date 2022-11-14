package info.sergeikolinichenko.cryptorates.data.models

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Created by Sergei Kolinichenko on 02.11.2022 at 17:00 (GMT+3) **/

data class CryptoInfoJsonContainerDto(
    @SerializedName("RAW")
    @Expose
    val json: JsonObject? = null
)
