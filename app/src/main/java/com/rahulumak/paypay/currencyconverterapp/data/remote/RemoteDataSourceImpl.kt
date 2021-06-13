package com.rahulumak.paypay.currencyconverterapp.data.remote

import com.rahulumak.paypay.currencyconverterapp.data.service.PayPayService
import com.rahulumak.paypay.currencyconverterapp.model.ConversionModel
import com.rahulumak.paypay.currencyconverterapp.model.CurrencyModel

class RemoteDataSourceImpl(private val payPayService: PayPayService) : RemoteDataSource {


    override suspend fun getCurrencyList(access_key: String): CurrencyModel {
        return payPayService.getCurrencyList(access_key)
    }

    override suspend fun getConversion(access_key: String, currencies: String): ConversionModel {
        return payPayService.getConversion(access_key, currencies)
    }
}