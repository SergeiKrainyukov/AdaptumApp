package com.example.adaptumapp.data.network

import com.example.adaptumapp.data.network.dto.TokenDataDto
import com.example.adaptumapp.domain.entity.User
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("api-token-auth/")
    suspend fun auth(@Body user: User): TokenDataDto
}