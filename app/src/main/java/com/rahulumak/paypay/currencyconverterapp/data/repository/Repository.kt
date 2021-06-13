package com.rahulumak.paypay.currencyconverterapp.data.repository

import com.rahulumak.paypay.currencyconverterapp.model.*

interface Repository {


    suspend fun getCurrencyList(
        access_key: String
    ): CurrencyModel

    suspend fun getConversion(
        access_key: String,
        currencies: String
    ): ConversionModel

    suspend fun getAllCurrency(): List<Currency>
    suspend fun getCurrencyRate(currencyCode: String):Double
    suspend fun getCurrencyConversion(currencyCode: String,amount:Double):Double
    suspend fun insertCurrency( currency: Currency)
    suspend fun updateCurrencyRate(currencyCode: String):Double
    suspend fun insertAllCurrency( currencies: List<Currency>)
    suspend fun getCount(): Int
    suspend fun getAllCurrencyWhoseExchangeAvailable(): List<Currency>
}