package info.sergeikolinichenko.cryptorates.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Created by Sergei Kolinichenko on 02.11.2022 at 16:51 (GMT+3) **/

data class CryptoNameContainerDto(
    @SerializedName("CoinInfo")
    @Expose
    val cryptoName: CryptoNameDto? = null
)
