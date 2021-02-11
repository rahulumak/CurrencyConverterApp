package com.rahulumak.mobiquity.mobiquityassignment.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.rahulumak.mobiquity.mobiquityassignment.model.City

@Dao
interface CityDao {
    @Query("SELECT * FROM city")
    fun getAllBookmarkedCities(): List<City>

    @Query("DELETE FROM city WHERE id=:cityId")
    fun deleteCity(cityId:Int)

    @Insert
    fun insertCity(vararg users: City)

    @Update
    fun updateCity(user: City)
}