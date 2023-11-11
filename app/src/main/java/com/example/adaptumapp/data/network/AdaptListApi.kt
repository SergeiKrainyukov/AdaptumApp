package com.example.adaptumapp.data.network

import com.example.adaptumapp.data.network.dto.AdaptPlanDto
import retrofit2.http.GET

interface AdaptListApi {
    @GET("api/onboarding/users/my/adapt/list")
    suspend fun getAdaptPlans(): List<AdaptPlanDto>
}