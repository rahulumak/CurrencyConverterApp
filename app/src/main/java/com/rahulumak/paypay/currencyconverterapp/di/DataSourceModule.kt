package com.rahulumak.paypay.currencyconverterapp.di

import com.rahulumak.paypay.currencyconverterapp.data.local.LocalDataSource
import com.rahulumak.paypay.currencyconverterapp.data.local.LocalDataSourceImpl
import com.rahulumak.paypay.currencyconverterapp.data.remote.RemoteDataSource
import com.rahulumak.paypay.currencyconverterapp.data.remote.RemoteDataSourceImpl
import org.koin.dsl.module

val dataSourceModule= module {
    single<RemoteDataSource> {
        RemoteDataSourceImpl(payPayService = get())
    }
    single<LocalDataSource> {
        LocalDataSourceImpl(currencyDao = get())
    }
}