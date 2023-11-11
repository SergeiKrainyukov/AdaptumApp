package com.example.adaptumapp.data.network

import com.example.adaptumapp.data.network.dto.AdaptPlanDto
import com.example.adaptumapp.data.network.dto.StageDto
import retrofit2.http.GET
import retrofit2.http.Path

interface AdaptListApi {
    @GET("api/onboarding/users/my/adapt/list")
    suspend fun getAdaptPlans(): List<AdaptPlanDto>

    @GET("api/onboarding/users/my/user-group/{groupId}/stages")
    suspend fun getStages(@Path("groupId") groupId: Int): List<StageDto>
}