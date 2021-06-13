package com.rahulumak.paypay.currencyconverterapp.data.local

import com.rahulumak.paypay.currencyconverterapp.data.room.CurrencyDao
import com.rahulumak.paypay.currencyconverterapp.model.Currency

class LocalDataSourceImpl(
    private val currencyDao: CurrencyDao) : LocalDataSource {

    override suspend fun getAllCurrency(): List<Currency> {
        return currencyDao.getAllCurrency()
    }

    override suspend fun getCurrencyRate(currencyCode: String):Double {
        return currencyDao.getCurrencyRate(currencyCode)
    }

    override suspend fun insertCurrency(currency: Currency) {
        return currencyDao.insertCurrency(currency)
    }

    override suspend fun updateCurrencyRate(currencyCode: String, currencyRate: Double,timestamp:Long) {
        return currencyDao.updateCurrencyRate(currencyCode, currencyRate,timestamp)
    }

    override suspend fun insertAllCurrency(currencies: List<Currency>) {
        return currencyDao.insertAllCurrency(currencies)
    }

    override suspend fun getCount(): Int {
        return currencyDao.getCount()
    }

    override suspend fun getCurrencyTimestamp(currencyCode: String): Long {
        return currencyDao.getCurrencyTimestamp(currencyCode)
    }
    override suspend fun getAllCurrencyWhoseExchangeAvailable(): List<Currency> {
        return currencyDao.getAllCurrencyWhoseExchangeAvailable()
    }
}