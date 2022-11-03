package info.sergeikolinichenko.cryptorates.data.model

import androidx.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Created by Sergei Kolinichenko on 02.11.2022 at 16:53 (GMT+3) **/

data class CryptoNameDto(
    @SerializedName("Name")
    @Expose
    val name: String? = null
)
