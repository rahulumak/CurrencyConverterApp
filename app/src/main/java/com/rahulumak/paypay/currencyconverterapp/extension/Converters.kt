package com.rahulumak.paypay.currencyconverterapp.extension

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData

import java.text.SimpleDateFormat
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit


object Converters {
    private fun getDateFormatter(): SimpleDateFormat {
        return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SSS", Locale.getDefault());
    }

    private fun getDateSmallFormatter(): SimpleDateFormat {
        return SimpleDateFormat("EEEE, d MMM yyyy", Locale.getDefault());
    }

    fun toSmallDate(date: Long): String {
        val formattedDate = Date(date * 1000L)
        return getDateSmallFormatter().format(formattedDate)
    }

    fun <T> MutableLiveData<T>.modifyValue(transform: T.() -> T) {
        this.value = this.value?.run(transform)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun getDifferenceInMinutes(timestamp: Long):Long{
        val inputDate=Date(timestamp*1000L)
        val currentDate=Date()
        val differenceInMinutes=currentDate.time-inputDate.time
        val minutes=TimeUnit.MINUTES.convert(differenceInMinutes,TimeUnit.MILLISECONDS)
        Log.d("Converters","Minutes==>$minutes")
        return minutes
    }
}
