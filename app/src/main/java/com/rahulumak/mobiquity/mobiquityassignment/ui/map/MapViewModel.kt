package com.rahulumak.mobiquity.mobiquityassignment.ui.map

import android.content.Context
import android.location.Geocoder
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.rahulumak.mobiquity.mobiquityassignment.data.repository.Repository
import com.rahulumak.mobiquity.mobiquityassignment.model.City
import kotlinx.coroutines.launch
import java.util.*

class MapViewModel(private val repository: Repository) : ViewModel() {
    val isMarkerAdded = MutableLiveData<LatLng?>()

    fun addBookmark(context: Context): MutableLiveData<Boolean> {
        val mutableLiveData = MutableLiveData<Boolean> ()
        viewModelScope.launch {
            val addresses = Geocoder(context, Locale.getDefault())
                .getFromLocation(isMarkerAdded.value!!.latitude, isMarkerAdded.value!!.longitude, 1)
            val city = addresses[0].locality

            repository.insertCity(City(city, isMarkerAdded.value!!.latitude, isMarkerAdded.value!!.longitude))

            mutableLiveData.postValue(true)
        }
        return mutableLiveData
    }
}