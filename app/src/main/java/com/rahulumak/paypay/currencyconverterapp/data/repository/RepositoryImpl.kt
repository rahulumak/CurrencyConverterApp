package com.rahulumak.paypay.currencyconverterapp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.rahulumak.paypay.currencyconverterapp.config.ProjectConfig
import com.rahulumak.paypay.currencyconverterapp.data.local.LocalDataSource
import com.rahulumak.paypay.currencyconverterapp.data.remote.RemoteDataSource
import com.rahulumak.paypay.currencyconverterapp.extension.Converters
import com.rahulumak.paypay.currencyconverterapp.model.*

class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : Repository {


    override suspend fun getCurrencyList(access_key: String): CurrencyModel {

        return remoteDataSource.getCurrencyList(access_key)
    }

    override suspend fun getConversion(access_key: String, currencies: String): ConversionModel {
        return remoteDataSource.getConversion(access_key,currencies)
    }

    override suspend fun getAllCurrency(): List<Currency> {
        return if (localDataSource.getCount()>0){
            localDataSource.getAllCurrency()
        }else{
            val currencyModel=remoteDataSource.getCurrencyList(ProjectConfig.ACCESS_KEY)
            val listCurrency= ArrayList<Currency>()
            for (currency in currencyModel.currencies){
                listCurrency.add(Currency(currency.key,currency.value))
            }
            localDataSource.insertAllCurrency(listCurrency)
            localDataSource.getAllCurrency()
        }
    }

    override suspend fun getCurrencyRate(currencyCode: String):Double {
        return localDataSource.getCurrencyRate(currencyCode)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getCurrencyConversion(currencyCode: String, amount: Double): Double {
        var currencyRate=localDataSource.getCurrencyRate(currencyCode)
        var conversion=0.0
         if (currencyRate>0.00){
             //Rates should be persisted locally and refreshed no more frequently than every 30 minutes (to limit bandwidth usage)
            if (Converters.getDifferenceInMinutes(localDataSource.getCurrencyTimestamp(currencyCode))>30){
                currencyRate=updateCurrencyRate(currencyCode)
                conversion= currencyRate*amount
            }else{
                conversion=currencyRate*amount
            }

        }else{

            currencyRate=updateCurrencyRate(currencyCode)
             conversion= currencyRate*amount
        }
        return conversion
    }

    override suspend fun insertCurrency(currency: Currency) {
        return localDataSource.insertCurrency(currency)
    }

    override suspend fun updateCurrencyRate(currencyCode: String):Double {
        val conversionModel=remoteDataSource.getConversion(ProjectConfig.ACCESS_KEY,currencyCode)
        for (currency in conversionModel.quotes){
            localDataSource.updateCurrencyRate(currencyCode, currency.value.toDouble(),conversionModel.timestamp)
        }
        return conversionModel.quotes["${ProjectConfig.CONVERSION_UNITS}$currencyCode"]!!.toDouble()
//        return localDataSource.updateCurrencyRate(currencyCode, currencyRate,timestamp)
    }

    override suspend fun insertAllCurrency(currencies: List<Currency>) {
        return localDataSource.insertAllCurrency(currencies)
    }

    override suspend fun getCount(): Int {
        return localDataSource.getCount()
    }
    override suspend fun getAllCurrencyWhoseExchangeAvailable(): List<Currency> {
        return localDataSource.getAllCurrencyWhoseExchangeAvailable()
    }

}