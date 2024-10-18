package com.safi.koinktor.core.di

import com.safi.koinktor.core.domain.usecase.UserApiUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { UserApiUseCase(get()) }
}