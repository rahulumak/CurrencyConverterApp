package com.rahulumak.mobiquity.mobiquityassignment.di

import com.rahulumak.mobiquity.mobiquityassignment.data.local.LocalDataSource
import com.rahulumak.mobiquity.mobiquityassignment.data.local.LocalDataSourceImpl
import com.rahulumak.mobiquity.mobiquityassignment.data.remote.RemoteDataSource
import com.rahulumak.mobiquity.mobiquityassignment.data.remote.RemoteDataSourceImpl
import com.rahulumak.mobiquity.mobiquityassignment.data.service.MobilquityService
import org.koin.dsl.module

val dataSourceModule= module {
    single<RemoteDataSource> {
        RemoteDataSourceImpl(mobilquityService = get())
    }
    single<LocalDataSource> {
        LocalDataSourceImpl(cityDao = get())
    }
}