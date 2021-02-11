package com.rahulumak.mobiquity.mobiquityassignment.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rahulumak.mobiquity.mobiquityassignment.model.City

@Database(entities = [City::class],version = 1)
abstract class AppDatabase: RoomDatabase() {
        abstract fun getCityDao():CityDao
}