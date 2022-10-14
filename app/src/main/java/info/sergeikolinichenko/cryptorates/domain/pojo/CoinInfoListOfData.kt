package info.sergeikolinichenko.cryptorates.domain.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Created by Sergei Kolinichenko on 10.2022 at 17:44 (GMT+3) **/

data class CoinInfoListOfData(
    @SerializedName("Data")
    @Expose
    val data: List<Datum>? = null
)
