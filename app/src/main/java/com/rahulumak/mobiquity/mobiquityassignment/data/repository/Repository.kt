package com.rahulumak.mobiquity.mobiquityassignment.data.repository

import com.rahulumak.mobiquity.mobiquityassignment.model.City
import com.rahulumak.mobiquity.mobiquityassignment.model.ForecastModel
import com.rahulumak.mobiquity.mobiquityassignment.model.WeatherModel

interface Repository {
    suspend fun getAllBookmarkedCities(): List<City>
    suspend fun insertCity(city: City)
    suspend fun updateCity(city: City)
    suspend fun deleteCity(cityId: Int)
    suspend fun getWeather(latitude: Double, longitude: Double, apiKey: String,
                           conversionUnits: String): WeatherModel
    suspend fun getForecast(
        latitude: Double,
        longitude: Double,
        apiKey: String,
        conversionUnits: String
    ): ForecastModel
}