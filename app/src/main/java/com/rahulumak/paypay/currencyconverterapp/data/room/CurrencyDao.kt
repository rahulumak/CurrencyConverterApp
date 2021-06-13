package com.rahulumak.paypay.currencyconverterapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rahulumak.paypay.currencyconverterapp.model.Currency

@Dao
interface CurrencyDao {
    @Query("SELECT * FROM currency")
    fun getAllCurrency(): List<Currency>

    @Query("SELECT * FROM currency WHERE rate>0.0")
    fun getAllCurrencyWhoseExchangeAvailable(): List<Currency>

    @Query("SELECT rate FROM currency WHERE code=:currencyCode")
    fun getCurrencyRate(currencyCode: String):Double

    @Query("SELECT timestamp FROM currency WHERE code=:currencyCode")
    fun getCurrencyTimestamp(currencyCode: String):Long

    @Insert
    fun insertCurrency(vararg currency: Currency)

    @Query("UPDATE currency SET rate=:currencyRate,timestamp=:timeStamp WHERE code=:currencyCode")
    fun updateCurrencyRate(currencyCode: String, currencyRate: Double, timeStamp:Long)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCurrency( currencies: List<Currency>)

    @Query("SELECT COUNT(id) FROM currency")
    fun getCount(): Int
}