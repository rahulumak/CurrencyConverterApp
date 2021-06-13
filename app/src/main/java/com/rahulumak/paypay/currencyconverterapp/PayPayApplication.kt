package com.rahulumak.paypay.currencyconverterapp

import android.app.Application
import com.rahulumak.paypay.currencyconverterapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PayPayApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PayPayApplication)
            modules(networkModule)
            modules(repositoryModule)
            modules(dataSourceModule)
            modules(roomModule)
            modules(viewModelModule)
        }
    }
}