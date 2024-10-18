package com.safi.koinktor.core.data.mapper

import com.safi.koinktor.core.model.apiresponse.UserApiResponse
import com.safi.koinktor.core.model.entity.UserEntity

class UserApiMapper : Mapper<List<UserApiResponse>, List<UserEntity>> {

    override fun mapFromApiResponse(type: List<UserApiResponse>): List<UserEntity> {
        return type.map {
            UserEntity(
                id = it.id?:-1,
                avatar_url = it.avatar_url?:"",
                description = it.description?:"",
                login = it.login?:"",
                node_id = it.node_id?:"",
            )
        }
    }

}
