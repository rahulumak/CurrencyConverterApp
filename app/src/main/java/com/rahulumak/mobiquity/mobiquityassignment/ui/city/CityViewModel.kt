package com.rahulumak.mobiquity.mobiquityassignment.ui.city

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahulumak.mobiquity.mobiquityassignment.data.repository.Repository
import com.rahulumak.mobiquity.mobiquityassignment.model.WeatherModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CityViewModel(private val repository: Repository) : ViewModel() {

     val weatherModel = MutableLiveData<WeatherModel>()
    init {

    }
    fun getWeatherData(latitude: Double, longitude: Double, apiKey: String,
                       conversionUnits: String):MutableLiveData<WeatherModel>{
        viewModelScope.launch(Dispatchers.IO) {
            isLoading.postValue(true)
            weatherModel.postValue(repository.getWeather(latitude, longitude, apiKey, conversionUnits))
            isLoading.postValue(false)
        }
        return weatherModel
    }

    val isLoading = MutableLiveData<Boolean>().apply {
        value = false
    }

}