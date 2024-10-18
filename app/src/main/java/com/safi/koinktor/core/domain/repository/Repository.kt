package com.safi.koinktor.core.domain.repository

import com.safi.koinktor.core.model.entity.UserEntity

interface Repository {

    suspend fun getUsers(): Result<List<UserEntity>>
}