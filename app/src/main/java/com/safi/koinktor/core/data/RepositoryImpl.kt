package com.safi.koinktor.core.data

import com.safi.koinktor.core.data.mapper.UserApiMapper
import com.safi.koinktor.core.data.mapper.mapFromApiResponse
import com.safi.koinktor.core.domain.repository.Repository
import com.safi.koinktor.core.model.apiresponse.UserApiResponse
import com.safi.koinktor.core.model.entity.UserEntity
import com.safi.koinktor.core.network.ApiService
import io.ktor.client.call.body

class RepositoryImpl(
    private val apiService: ApiService,
    private val userApiMapper: UserApiMapper
) : Repository {

    override suspend fun getUsers(): Result<List<UserEntity>> {
        return runCatching {
            mapFromApiResponse(
                apiService.getUsers().body<List<UserApiResponse>>(),
                userApiMapper
            )
        }
    }

}