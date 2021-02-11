package com.rahulumak.mobiquity.mobiquityassignment.data.local

import com.rahulumak.mobiquity.mobiquityassignment.data.room.CityDao
import com.rahulumak.mobiquity.mobiquityassignment.model.City

class LocalDataSourceImpl(private val cityDao: CityDao):LocalDataSource {
    override suspend fun getAllBookmarkedCities(): List<City> {
        return cityDao.getAllBookmarkedCities()
    }

    override suspend fun insertCity(city: City) {
        cityDao.insertCity(city)
    }

    override suspend fun updateCity(city: City) {
        cityDao.updateCity(city)
    }
    override suspend fun deleteCity(cityId: Int){
        cityDao.deleteCity(cityId)
    }
}