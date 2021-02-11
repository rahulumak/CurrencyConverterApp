package com.rahulumak.mobiquity.mobiquityassignment.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.rahulumak.mobiquity.mobiquityassignment.config.ProjectConfig
import com.rahulumak.mobiquity.mobiquityassignment.data.room.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val roomModule= module {

    single {
        Room.databaseBuilder(androidApplication(),AppDatabase::class.java,ProjectConfig.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
    single {
        get<AppDatabase>().getCityDao()
    }
}