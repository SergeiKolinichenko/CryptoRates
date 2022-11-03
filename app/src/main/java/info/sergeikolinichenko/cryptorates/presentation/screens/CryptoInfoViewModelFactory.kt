package info.sergeikolinichenko.cryptorates.presentation.screens

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/** Created by Sergei Kolinichenko on 02.11.2022 at 19:38 (GMT+3) **/

class CryptoInfoViewModelFactory(application: Application): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(CryptoInfoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            CryptoInfoViewModel(

            ) as T
        } else {
            throw RuntimeException("Unknown view Model class $modelClass")
        }
    }
}