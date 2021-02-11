package com.rahulumak.mobiquity.mobiquityassignment.extension

import androidx.lifecycle.MutableLiveData
import java.text.SimpleDateFormat
import java.util.*


object Converters {
    private fun getDateFormatter(): SimpleDateFormat {
        return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SSS", Locale.getDefault());
    }

    private fun getDateSmallFormatter(): SimpleDateFormat {
        return SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault());
    }

    fun toSmallDate(date: Long): String {
        val formattedDate = Date(date * 1000L)
        return getDateSmallFormatter().format(formattedDate!!)
    }

    fun <T> MutableLiveData<T>.modifyValue(transform: T.() -> T) {
        this.value = this.value?.run(transform)
    }
}
