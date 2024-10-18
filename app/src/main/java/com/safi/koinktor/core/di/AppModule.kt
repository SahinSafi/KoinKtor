package com.safi.koinktor.core.di

import org.koin.dsl.module

val appModule = module {
    includes(networkModule, repositoryModule, mapperModule, useCaseModule, viewModelModule)
}
