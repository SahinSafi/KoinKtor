package com.safi.koinktor.core.di

import com.safi.koinktor.presentation.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}