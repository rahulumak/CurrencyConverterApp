package com.rahulumak.paypay.currencyconverterapp.ui.currencyConverter

import androidx.lifecycle.*
import com.rahulumak.paypay.currencyconverterapp.data.repository.Repository
import com.rahulumak.paypay.currencyconverterapp.model.Currency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CurrencyConverterViewModel(private val repository: Repository) : ViewModel() {

    val currencyList: MutableLiveData<List<Currency>> = MutableLiveData<List<Currency>>()
    val exchangeList: MutableLiveData<List<Currency>> = MutableLiveData<List<Currency>>()

    val conversionValue:MutableLiveData<Double> = MutableLiveData<Double>()
    fun getCurrencies(): MutableLiveData<List<Currency>> {
        viewModelScope.launch(Dispatchers.IO) {
            currencyList.postValue(repository.getAllCurrency())
        }
        return currencyList
    }
    fun getConversion(conversionCode: String, amount: Double):MutableLiveData<Double>{
        viewModelScope.launch(Dispatchers.IO) {
            conversionValue.postValue(repository.getCurrencyConversion(conversionCode,amount))

        }
        return conversionValue
    }
    fun getAvailableExchangeList(): MutableLiveData<List<Currency>>{
        viewModelScope.launch(Dispatchers.IO) {
            exchangeList.postValue(repository.getAllCurrencyWhoseExchangeAvailable())
        }
        return exchangeList
    }


}