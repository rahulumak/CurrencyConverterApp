package com.rahulumak.mobiquity.mobiquityassignment.data.service

import com.rahulumak.mobiquity.mobiquityassignment.model.ForecastModel
import com.rahulumak.mobiquity.mobiquityassignment.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MobilquityService {
    @GET("weather")
    suspend fun getWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String,
        @Query("units") conversionUnits: String
    ):WeatherModel

    @GET("forecast")
    suspend fun getForecast(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String,
        @Query("units") conversionUnits: String
    ):ForecastModel
}