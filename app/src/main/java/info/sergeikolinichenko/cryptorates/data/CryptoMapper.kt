package info.sergeikolinichenko.cryptorates.data

import com.google.gson.Gson
import info.sergeikolinichenko.cryptorates.data.database.CryptoInfoDbModel
import info.sergeikolinichenko.cryptorates.data.model.CryptoInfoDto
import info.sergeikolinichenko.cryptorates.data.model.CryptoInfoJsonContainerDto
import info.sergeikolinichenko.cryptorates.data.model.CryptoNamesListDto
import info.sergeikolinichenko.cryptorates.domain.models.CryptoInfo

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
        imageUrl = dto.imageUrl
    )

    fun mapDbModelToEntity(dbModel: CryptoInfoDbModel) = CryptoInfo(
        fromSymbol = dbModel.fromSymbol,
        toSymbol = dbModel.toSymbol,
        price = dbModel.price,
        lastUpdate = dbModel.lastUpdate,
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

    fun mapNamesListToString(nameListDto: CryptoNamesListDto): String {
        return nameListDto.names?.map {
            it.cryptoName?.name
        }?.joinToString { SEPARATOR } ?: EMPTY_STRING
    }

    companion object {
        const val SEPARATOR = ","
        const val EMPTY_STRING = ""
    }
}