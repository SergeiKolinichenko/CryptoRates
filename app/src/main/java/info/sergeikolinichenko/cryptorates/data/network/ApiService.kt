package info.sergeikolinichenko.cryptorates.data.network

import info.sergeikolinichenko.cryptorates.data.models.CoinInfoListDto
import io.reactivex.Single
import retrofit2.http.GET

/** Created by Sergei Kolinichenko on 14.10.2022 at 21:07 (GMT+3) **/

interface ApiService {

    @GET("top/totalvolfull")
    fun getCoinsInfo(): Single<CoinInfoListDto>

    companion object{
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
    }
}