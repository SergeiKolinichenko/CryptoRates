package info.sergeikolinichenko.cryptorates.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Created by Sergei Kolinichenko on 14.10.2022 at 20:39 (GMT+3) **/

data class CoinInfoDto(
    @SerializedName("Id")
    @Expose
    val id: String? = null,

    @SerializedName("Name")
    @Expose
    val name: String? = null,

    @SerializedName("FullName")
    @Expose
    val fullName: String? = null,

    @SerializedName("ImageUrl")
    @Expose
    val imageUrl: String? = null
)
