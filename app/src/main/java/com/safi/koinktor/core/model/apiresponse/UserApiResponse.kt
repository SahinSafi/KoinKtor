package com.safi.koinktor.core.model.apiresponse

import kotlinx.serialization.Serializable

@Serializable
data class UserApiResponse(
    val avatar_url: String?,
    val description: String?,
    val events_url: String?,
    val hooks_url: String?,
    val id: Int?,
    val issues_url: String?,
    val login: String?,
    val members_url: String?,
    val node_id: String?,
    val public_members_url: String?,
    val repos_url: String?,
    val url: String?
)
