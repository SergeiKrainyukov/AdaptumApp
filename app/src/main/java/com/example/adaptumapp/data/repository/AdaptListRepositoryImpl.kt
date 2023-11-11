package com.example.adaptumapp.data.repository

import com.example.adaptumapp.data.network.AdaptListApi
import com.example.adaptumapp.domain.entity.AdaptPlan
import com.example.adaptumapp.domain.repository.AdaptListRepository
import javax.inject.Inject

class AdaptListRepositoryImpl @Inject constructor(
    private val adaptListApi: AdaptListApi
): AdaptListRepository {
    override suspend fun getAdaptPlans(): List<AdaptPlan> {
        return adaptListApi.getAdaptPlans().map { it.toModel() }
    }
}