package com.rahulumak.mobiquity.mobiquityassignment.data.repository

import com.rahulumak.mobiquity.mobiquityassignment.data.local.LocalDataSource
import com.rahulumak.mobiquity.mobiquityassignment.data.remote.RemoteDataSource
import com.rahulumak.mobiquity.mobiquityassignment.model.City
import com.rahulumak.mobiquity.mobiquityassignment.model.ForecastModel
import com.rahulumak.mobiquity.mobiquityassignment.model.WeatherModel

class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : Repository {
    override suspend fun getAllBookmarkedCities(): List<City> {
        return localDataSource.getAllBookmarkedCities()
    }

    override suspend fun insertCity(city: City) {
        localDataSource.insertCity(city)
    }

    override suspend fun updateCity(city: City) {
        localDataSource.updateCity(city)
    }
    override suspend fun deleteCity(cityId: Int){
        localDataSource.deleteCity(cityId)
    }

    override suspend fun getWeather(
        latitude: Double,
        longitude: Double,
        apiKey: String,
        conversionUnits: String
    ): WeatherModel {
        return remoteDataSource.getWeather(
            latitude, longitude, apiKey,
            conversionUnits
        )
    }

    override suspend fun getForecast(
        latitude: Double,
        longitude: Double,
        apiKey: String,
        conversionUnits: String
    ): ForecastModel {
        return remoteDataSource.getForecast(latitude, longitude, apiKey, conversionUnits)
    }

}