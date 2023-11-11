package com.example.adaptumapp.data.network

import com.example.adaptumapp.data.network.dto.AdaptPlanDto
import com.example.adaptumapp.data.network.dto.StageDto
import retrofit2.http.GET

interface AdaptListApi {
    @GET("api/onboarding/users/my/adapt/list")
    suspend fun getAdaptPlans(): List<AdaptPlanDto>

    @GET("api/onboarding/users/my/user-group/48/stages")
    suspend fun getStages(): List<StageDto>
}