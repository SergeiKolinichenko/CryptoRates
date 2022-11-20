package info.sergeikolinichenko.cryptorates.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import info.sergeikolinichenko.cryptorates.data.database.AppDatabase
import info.sergeikolinichenko.cryptorates.data.CryptoMapper
import info.sergeikolinichenko.cryptorates.data.network.ApiFactory
import info.sergeikolinichenko.cryptorates.domain.CryptoRepository
import info.sergeikolinichenko.cryptorates.domain.model.CryptoInfo
import kotlinx.coroutines.delay

/** Created by Sergei Kolinichenko on 02.11.2022 at 19:45 (GMT+3) **/

class CryptoRepositoryImpl(application: Application): CryptoRepository {

    private val cryptoInfoDao = AppDatabase.getInstance(application).cryptoInfoDao()
    private val apiService = ApiFactory.apiService
    private val mapper = CryptoMapper()

    override fun getCryptoInfoList(): LiveData<List<CryptoInfo>> {
        return Transformations.map(
            cryptoInfoDao.getPriceList()
        ) { it ->
            it.map {
            mapper.mapDbModelToEntity(it)
        }}
    }

    override fun getCryptoInfo(fromSymbol: String): LiveData<CryptoInfo> {
        return Transformations.map(
            cryptoInfoDao.getPriceInfoAboutCoin(fromSymbol)
        ){
            mapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun loadCryptoData() {
        while (true) {
            try {
                val topCoins = apiService.getTopCryptoInfo(limit = LIMIT_TOP_COINS)
                val fSyms = mapper.mapNamesListToString(topCoins)
                val jsonContainer = apiService.getFullPriceList(fSyms = fSyms)
                val coinInfoDtoList = mapper.mapJsonContainerToListCryptoInfo(jsonContainer)
                val dbModelList = coinInfoDtoList.map { mapper.mapDtoToDbModel(it) }
                Log.d("MyLog", "dbModelList $dbModelList")
                cryptoInfoDao.insertPriceList(dbModelList)
            } catch (e: Exception) {
                Log.ERROR
            }
            delay(RECEIVE_DELAY_JSON)
        }
    }

    companion object {
        const val LIMIT_TOP_COINS = 50
        private const val RECEIVE_DELAY_JSON = 60000L
    }
}