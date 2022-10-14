package info.sergeikolinichenko.cryptorates.domain.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Created by Sergei Kolinichenko on 10.2022 at 16:33 (GMT+3) **/

data class Datum(
    @SerializedName("CoinInfo")
    @Expose
    val coinInfo: CoinInfo? = null
)
