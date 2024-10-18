package com.safi.koinktor.core.di

import com.safi.koinktor.core.data.RepositoryImpl
import com.safi.koinktor.core.domain.repository.Repository
import org.koin.dsl.module

val repositoryModule = module {
    single <Repository> { RepositoryImpl(get(),get()) }
}