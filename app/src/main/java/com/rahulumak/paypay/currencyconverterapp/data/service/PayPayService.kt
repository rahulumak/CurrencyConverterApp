package com.rahulumak.paypay.currencyconverterapp.data.service

import com.rahulumak.paypay.currencyconverterapp.model.ConversionModel
import com.rahulumak.paypay.currencyconverterapp.model.CurrencyModel
import retrofit2.http.GET
import retrofit2.http.Query

interface PayPayService {

    @GET("list")
    suspend fun getCurrencyList(
        @Query("access_key") access_key: String
    ):CurrencyModel

    @GET("live")
    suspend fun getConversion(
        @Query("access_key") access_key: String,
        @Query("currencies") currencies: String,
    ):ConversionModel


}