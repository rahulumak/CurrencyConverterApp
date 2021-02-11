package com.rahulumak.mobiquity.mobiquityassignment.data.local

import com.rahulumak.mobiquity.mobiquityassignment.model.City

interface LocalDataSource {
    suspend fun getAllBookmarkedCities(): List<City>
    suspend fun insertCity(city: City)
    suspend fun updateCity(city: City)
    suspend fun deleteCity(cityId: Int)
}