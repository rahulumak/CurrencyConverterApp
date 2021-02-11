package com.rahulumak.mobiquity.mobiquityassignment.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherModel(
    @SerializedName("base")
    val base: String,
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("cod")
    val cod: Int,
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("dt")
    val dt: Long,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: Main,
    @SerializedName("name")
    val name: String,
    @SerializedName("sys")
    val sys: Sys,
    @SerializedName("timezone")
    val timezone: Int,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("wind")
    val wind: Wind
):Parcelable {
    @Parcelize
    data class Clouds(
        @SerializedName("all")
        val all: Int
    ):Parcelable
    @Parcelize
    data class Coord(
        @SerializedName("lat")
        val lat: Double,
        @SerializedName("lon")
        val lon: Double
    ):Parcelable
    @Parcelize
    data class Main(
        @SerializedName("feels_like")
        val feelsLike: Double,
        @SerializedName("humidity")
        val humidity: Int,
        @SerializedName("pressure")
        val pressure: Int,
        @SerializedName("temp")
        val temp: Double,
        @SerializedName("temp_max")
        val tempMax: Double,
        @SerializedName("temp_min")
        val tempMin: Double
    ):Parcelable
    @Parcelize
    data class Sys(
        @SerializedName("country")
        val country: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("sunrise")
        val sunrise: Int,
        @SerializedName("sunset")
        val sunset: Int,
        @SerializedName("type")
        val type: Int
    ):Parcelable
    @Parcelize
    data class Weather(
        @SerializedName("description")
        val description: String,
        @SerializedName("icon")
        val icon: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("main")
        val main: String
    ):Parcelable {
        fun getIconUrl(): String {
            return "http://openweathermap.org/img/wn/$icon@2x.png"
        }
    }
    @Parcelize
    data class Wind(
        @SerializedName("deg")
        val deg: Int,
        @SerializedName("speed")
        val speed: Double
    ):Parcelable
}