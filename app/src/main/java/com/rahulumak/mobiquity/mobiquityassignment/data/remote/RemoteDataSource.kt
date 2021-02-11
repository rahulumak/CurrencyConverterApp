package com.rahulumak.mobiquity.mobiquityassignment.data.remote

import com.rahulumak.mobiquity.mobiquityassignment.model.ForecastModel
import com.rahulumak.mobiquity.mobiquityassignment.model.WeatherModel

interface RemoteDataSource {
    suspend fun getWeather(
        latitude: Double, longitude: Double, apiKey: String,
        conversionUnits: String
    ): WeatherModel

    suspend fun getForecast(
        latitude: Double,
        longitude: Double,
        apiKey: String,
        conversionUnits: String
    ): ForecastModel
}