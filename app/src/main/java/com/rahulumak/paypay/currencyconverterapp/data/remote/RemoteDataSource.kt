package com.rahulumak.paypay.currencyconverterapp.data.remote

import com.rahulumak.paypay.currencyconverterapp.model.ConversionModel
import com.rahulumak.paypay.currencyconverterapp.model.CurrencyModel

interface RemoteDataSource {

    suspend fun getCurrencyList(
        access_key: String
    ): CurrencyModel

    suspend fun getConversion(
        access_key: String,
        currencies: String
    ): ConversionModel
}