package info.sergeikolinichenko.cryptorates.data.database

import android.util.Log
import com.google.gson.Gson
import info.sergeikolinichenko.cryptorates.data.models.CryptoInfoDto
import info.sergeikolinichenko.cryptorates.data.models.CryptoInfoJsonContainerDto
import info.sergeikolinichenko.cryptorates.data.models.CryptoNamesListDto
import info.sergeikolinichenko.cryptorates.domain.model.CryptoInfo
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

/** Created by Sergei Kolinichenko on 02.11.2022 at 20:30 (GMT+3) **/

class CryptoMapper {

    fun mapDtoToDbModel(dto: CryptoInfoDto) = CryptoInfoDbModel(
        fromSymbol = dto.fromSymbol,
        toSymbol = dto.toSymbol,
        price = dto.price,
        lastUpdate = dto.lastUpdate,
        highDay = dto.highDay,
        lowDay = dto.lowDay,
        lastMarket = dto.lastMarket,
        imageUrl = BASE_IMAGE_URL + dto.imageUrl
    )

    fun mapDbModelToEntity(dbModel: CryptoInfoDbModel) = CryptoInfo(
        fromSymbol = dbModel.fromSymbol,
        toSymbol = dbModel.toSymbol,
        price = dbModel.price,
        lastUpdate = convertTimestampToTime(dbModel.lastUpdate),
        highDay = dbModel.highDay,
        lowDay = dbModel.lowDay,
        lastMarket = dbModel.lastMarket,
        imageUrl = dbModel.imageUrl
    )

    fun mapJsonContainerToListCryptoInfo(
        jsonContainer: CryptoInfoJsonContainerDto
    ): List<CryptoInfoDto> {
        val result = mutableListOf<CryptoInfoDto>()
        val jsonObject = jsonContainer.json ?: return result
        val cryptoKeySet = jsonObject.keySet()

        for (cryptoKey in cryptoKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(cryptoKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CryptoInfoDto::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    fun mapNamesListToString(namesListDto: CryptoNamesListDto): String {
        return namesListDto.names?.map {
            it.cryptoName?.name
        }?.joinToString(SEPARATOR) ?: EMPTY_STRING
    }

    private fun convertTimestampToTime(timestamp: Long?): String {
        if (timestamp == null) return ""
        val stamp = Timestamp(timestamp * 1000)
        val date = Date(stamp.time)
        val pattern = "HH:mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }

    companion object {
        const val BASE_IMAGE_URL = "https://cryptocompare.com"
        const val SEPARATOR = ","
        const val EMPTY_STRING = ""
    }
}