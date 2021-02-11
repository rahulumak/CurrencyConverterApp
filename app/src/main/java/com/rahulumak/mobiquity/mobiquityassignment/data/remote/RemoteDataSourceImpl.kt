package com.rahulumak.mobiquity.mobiquityassignment.data.remote

import com.rahulumak.mobiquity.mobiquityassignment.data.service.MobilquityService
import com.rahulumak.mobiquity.mobiquityassignment.model.ForecastModel
import com.rahulumak.mobiquity.mobiquityassignment.model.WeatherModel

class RemoteDataSourceImpl(private val mobilquityService: MobilquityService) : RemoteDataSource {
    override suspend fun getWeather(
        latitude: Double,
        longitude: Double,
        apiKey: String,
        conversionUnits: String
    ): WeatherModel {
        return mobilquityService.getWeather(latitude, longitude, apiKey,conversionUnits)
    }

    override suspend fun getForecast(
        latitude: Double,
        longitude: Double,
        apiKey: String,
        conversionUnits: String
    ): ForecastModel {
        return mobilquityService.getForecast(latitude, longitude, apiKey, conversionUnits)
    }
}