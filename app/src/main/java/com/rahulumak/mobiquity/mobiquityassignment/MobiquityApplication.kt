package com.rahulumak.mobiquity.mobiquityassignment

import android.app.Application
import com.rahulumak.mobiquity.mobiquityassignment.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MobiquityApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MobiquityApplication)
            modules(networkModule)
            modules(repositoryModule)
            modules(dataSourceModule)
            modules(roomModule)
            modules(viewModelModule)
        }
    }
}