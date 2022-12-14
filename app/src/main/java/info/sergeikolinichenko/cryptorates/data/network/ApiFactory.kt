package info.sergeikolinichenko.cryptorates.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/** Created by Sergei Kolinichenko on 14.10.2022 at 21:07 (GMT+3) **/

object ApiFactory {

    private const val BASE_URL = "https://min-api.cryptocompare.com/data/"
    const val BASE_IMAGE_URL = "https://cryptocompare.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val apiService = retrofit.create(ApiService::class.java)

}