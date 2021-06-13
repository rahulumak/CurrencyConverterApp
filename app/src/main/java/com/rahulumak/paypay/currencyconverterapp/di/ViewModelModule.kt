package com.rahulumak.paypay.currencyconverterapp.di

import com.rahulumak.paypay.currencyconverterapp.ui.currencyConverter.CurrencyConverterViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        CurrencyConverterViewModel(repository = get())
    }
}