package com.rahulumak.mobiquity.mobiquityassignment.ui.home

import androidx.lifecycle.*
import com.rahulumak.mobiquity.mobiquityassignment.data.repository.Repository
import com.rahulumak.mobiquity.mobiquityassignment.model.City
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel() {

    val cityList: MutableLiveData<List<City>> = MutableLiveData<List<City>>()

    fun getBookmarkCities(): MutableLiveData<List<City>> {
        viewModelScope.launch(Dispatchers.IO) {
            cityList.postValue(repository.getAllBookmarkedCities())
        }
        return cityList
    }
    fun deleteCity(cityId:Int){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCity(cityId)
            cityList.postValue(repository.getAllBookmarkedCities())
        }
    }
}