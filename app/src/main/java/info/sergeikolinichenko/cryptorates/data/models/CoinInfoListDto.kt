package info.sergeikolinichenko.cryptorates.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import info.sergeikolinichenko.cryptorates.domain.models.Datum

/** Created by Sergei Kolinichenko on 14.10.2022 at 20:41 (GMT+3) **/

data class CoinInfoListDto (
    @SerializedName("Data")
    @Expose
    val data: List<Datum>? = null
)