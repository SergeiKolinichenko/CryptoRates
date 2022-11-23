package info.sergeikolinichenko.cryptorates.di

import android.app.Application

/** Created by Sergei Kolinichenko on 23.11.2022 at 20:00 (GMT+3) **/

class CryptoApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}