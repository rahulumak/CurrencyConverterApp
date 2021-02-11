package com.rahulumak.mobiquity.mobiquityassignment.di

import com.rahulumak.mobiquity.mobiquityassignment.data.repository.Repository
import com.rahulumak.mobiquity.mobiquityassignment.data.repository.RepositoryImpl
import org.koin.dsl.module

val repositoryModule= module {
    single<Repository> {
        RepositoryImpl(remoteDataSource = get(),localDataSource = get())
    }
}