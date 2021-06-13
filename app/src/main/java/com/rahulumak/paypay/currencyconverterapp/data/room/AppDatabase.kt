package com.rahulumak.paypay.currencyconverterapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rahulumak.paypay.currencyconverterapp.model.Currency

@Database(entities = [Currency::class],version = 1,exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
        abstract fun getCurrencyDao():CurrencyDao
}