package com.rahulumak.paypay.currencyconverterapp.di

import com.rahulumak.paypay.currencyconverterapp.data.repository.Repository
import com.rahulumak.paypay.currencyconverterapp.data.repository.RepositoryImpl
import org.koin.dsl.module

val repositoryModule= module {
    single<Repository> {
        RepositoryImpl(remoteDataSource = get(),localDataSource = get())
    }
}