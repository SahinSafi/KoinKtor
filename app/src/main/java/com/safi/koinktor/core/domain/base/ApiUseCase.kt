package com.safi.koinktor.core.domain.base

interface UseCase

interface ApiUseCase<Params, Type> : UseCase {
    suspend fun execute(params: Params): Result<Type>
}
