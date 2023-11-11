package com.example.adaptumapp.data.network.api

import com.example.adaptumapp.data.network.dto.ProfileDataDto
import retrofit2.http.GET

interface ProfileDataApi {
    @GET("/api/myprofile/")
    suspend fun getProfileData(): List<ProfileDataDto>
}