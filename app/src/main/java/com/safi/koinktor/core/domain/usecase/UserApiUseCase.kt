package com.safi.koinktor.core.domain.usecase

import com.safi.koinktor.core.domain.base.ApiUseCase
import com.safi.koinktor.core.domain.repository.Repository
import com.safi.koinktor.core.model.entity.UserEntity

class UserApiUseCase(private val repository: Repository) : ApiUseCase<Unit, List<UserEntity>> {

    override suspend fun execute(params: Unit): Result<List<UserEntity>> {
        return repository.getUsers()
    }

}