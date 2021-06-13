package com.rahulumak.paypay.currencyconverterapp.di

import androidx.room.Room
import com.rahulumak.paypay.currencyconverterapp.config.ProjectConfig
import com.rahulumak.paypay.currencyconverterapp.data.room.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val roomModule= module {

    single {
        Room.databaseBuilder(androidApplication(),AppDatabase::class.java,ProjectConfig.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    single {
        get<AppDatabase>().getCurrencyDao()
    }
}