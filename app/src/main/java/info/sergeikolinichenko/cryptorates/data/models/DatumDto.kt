package info.sergeikolinichenko.cryptorates.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import info.sergeikolinichenko.cryptorates.domain.models.CoinInfo

/** Created by Sergei Kolinichenko on 14.10.2022 at 20:53 (GMT+3) **/

data class DatumDto(
    @SerializedName("CoinInfo")
    @Expose
    val coinInfo: CoinInfo? = null
)
