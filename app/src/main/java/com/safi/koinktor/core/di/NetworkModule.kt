package com.safi.koinktor.core.di

import com.safi.koinktor.core.network.ApiService
import com.safi.koinktor.core.network.httpClientAndroid
import org.koin.dsl.module

val networkModule = module {
    single { httpClientAndroid }
    single { ApiService(get()) }
}