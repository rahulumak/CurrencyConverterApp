package com.rahulumak.paypay.currencyconverterapp.model


import com.google.gson.annotations.SerializedName

data class CurrencyModel(
    @SerializedName("currencies")
    val currencies: Map<String,String>,
    @SerializedName("privacy")
    val privacy: String,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("terms")
    val terms: String
)