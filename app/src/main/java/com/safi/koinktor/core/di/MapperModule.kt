package com.safi.koinktor.core.di

import com.safi.koinktor.core.data.mapper.UserApiMapper
import org.koin.dsl.module

val mapperModule = module {
    single { UserApiMapper() }
}