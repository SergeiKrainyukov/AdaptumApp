package com.example.adaptumapp.data.network

import com.example.adaptumapp.domain.entity.UserData
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("api-token-auth/")
    suspend fun auth(@Body userData: UserData): TokenDataDto
}