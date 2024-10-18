package com.safi.koinktor.core.network

import io.ktor.client.HttpClient
import io.ktor.client.request.forms.submitForm
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.parameters

class ApiService(private val client: HttpClient) {

    companion object {
        private const val USERS = "https://api.github.com/users/hadley/orgs"
    }

    suspend fun getUsers() = client.get(USERS) {

    }

    suspend fun postRequest() {
        val response = client.post("http://localhost:8080/customer") {
            contentType(ContentType.Application.Json)
            setBody("Data object")
        }
        runCatching {  }
    }

    suspend fun multipartRequest() {
        val response = client.submitForm(
            url = "http://localhost:8080/signup",
            formParameters = parameters {
                append("username", "JetBrains")
                append("email", "example@jetbrains.com")
                append("password", "foobar")
                append("confirmation", "foobar")
            }
        )
    }
}
