package com.rahulumak.mobiquity.mobiquityassignment.ui.city

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahulumak.mobiquity.mobiquityassignment.data.repository.Repository
import com.rahulumak.mobiquity.mobiquityassignment.model.ForecastModel
import com.rahulumak.mobiquity.mobiquityassignment.model.WeatherModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CityViewModel(private val repository: Repository) : ViewModel() {

    val weatherModel = MutableLiveData<WeatherModel>()

    init {

    }

    fun getWeatherData(
        latitude: Double, longitude: Double, apiKey: String,
        conversionUnits: String
    ): MutableLiveData<WeatherModel> {
        viewModelScope.launch(Dispatchers.IO) {
            isLoading.postValue(true)
            weatherModel.postValue(
                repository.getWeather(
                    latitude,
                    longitude,
                    apiKey,
                    conversionUnits
                )
            )
            isLoading.postValue(false)
        }
        return weatherModel
    }

    val isLoading = MutableLiveData<Boolean>().apply {
        value = false
    }

    val forecastList = MutableLiveData<List<DayForecast>>()

    fun getForecastList(
        latitude: Double, longitude: Double, apiKey: String,
        conversionUnits: String
    ): MutableLiveData<List<DayForecast>> {
        viewModelScope.launch {
            val forecast = repository.getForecast(latitude, longitude, apiKey, conversionUnits)
            val list = ArrayList<DayForecast>()
            val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())
            val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
            forecast.list.forEach { forecastListItem ->
                val itemDate = Date(forecastListItem.dt * 1000)
                val dateText = dateFormat.format(itemDate)
                val found = list.find { it.dateText == dateText }
                if (found == null) {
                    // create new and add
                    list.add(
                        DayForecast(
                            dateText = dateText,
                            dayText = dayFormat.format(itemDate),
                            ArrayList<ForecastModel.ForecastList>().apply {
                                add(forecastListItem)
                            }
                        )
                    )
                } else {
                    found.list.add(0, forecastListItem)
                }
            }
            list.removeAt(0)
            forecastList.postValue(list)
        }
        return forecastList
    }

}