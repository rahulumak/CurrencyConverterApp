package com.rahulumak.paypay.currencyconverterapp.data.local

import com.rahulumak.paypay.currencyconverterapp.model.Currency

interface LocalDataSource {

    suspend fun getAllCurrency(): List<Currency>
    suspend fun getCurrencyRate(currencyCode: String):Double
    suspend fun insertCurrency( currency: Currency)
    suspend fun updateCurrencyRate(currencyCode: String, currencyRate: Double,timestamp:Long)
    suspend fun insertAllCurrency( currencies: List<Currency>)
    suspend fun getCount(): Int
    suspend fun getCurrencyTimestamp(currencyCode: String):Long
    suspend fun getAllCurrencyWhoseExchangeAvailable(): List<Currency>

}