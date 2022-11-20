package info.sergeikolinichenko.cryptorates.data.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Created by Sergei Kolinichenko on 02.11.2022 at 16:52 (GMT+3) **/

data class CryptoNamesListDto(
    @SerializedName("Data")
    @Expose
    val names: List<CryptoNameContainerDto>? = null
)
