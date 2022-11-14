package info.sergeikolinichenko.cryptorates.data.network

import info.sergeikolinichenko.cryptorates.data.models.CryptoInfoJsonContainerDto
import info.sergeikolinichenko.cryptorates.data.models.CryptoNamesListDto
import retrofit2.http.GET
import retrofit2.http.Query

/** Created by Sergei Kolinichenko on 02.11.2022 at 17:02 (GMT+3) **/

interface ApiService {

    @GET("top/totalvolfull")
    suspend fun getTopCryptoInfo(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "",
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String = CURRENCY
    ): CryptoNamesListDto

    @GET("pricemultifull")
    suspend fun getFullPriceList(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "",
        @Query(QUERY_PARAM_FROM_SYMBOLS) fSyms: String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms: String = CURRENCY
    ): CryptoInfoJsonContainerDto

    companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
        private const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"

        private const val CURRENCY = "USD"
    }
}