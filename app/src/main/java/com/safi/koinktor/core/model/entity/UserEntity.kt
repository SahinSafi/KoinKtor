package com.safi.koinktor.core.model.entity

data class UserEntity(
    val avatar_url: String,
    val description: String,
    val id: Int,
    val login: String,
    val node_id: String,
)
