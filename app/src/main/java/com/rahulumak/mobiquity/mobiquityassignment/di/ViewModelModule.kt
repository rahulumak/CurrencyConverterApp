package com.rahulumak.mobiquity.mobiquityassignment.di

import com.rahulumak.mobiquity.mobiquityassignment.ui.city.CityViewModel
import com.rahulumak.mobiquity.mobiquityassignment.ui.home.HomeViewModel
import com.rahulumak.mobiquity.mobiquityassignment.ui.map.MapViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MapViewModel(repository = get())
    }
    viewModel {
        HomeViewModel(repository = get())
    }
    viewModel {
        CityViewModel(repository = get())
    }
}