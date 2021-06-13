package com.rahulumak.paypay.currencyconverterapp.model


import com.google.gson.annotations.SerializedName

data class ConversionModel(
    @SerializedName("privacy")
    val privacy: String,
    @SerializedName("quotes")
    val quotes: Map<String,String>,
    @SerializedName("source")
    val source: String,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("terms")
    val terms: String,
    @SerializedName("timestamp")
    val timestamp: Long
)