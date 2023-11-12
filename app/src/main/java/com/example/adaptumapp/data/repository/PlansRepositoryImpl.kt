package com.example.adaptumapp.data.repository

import com.example.adaptumapp.data.network.api.AdaptListApi
import com.example.adaptumapp.domain.entity.AdaptPlan
import com.example.adaptumapp.domain.entity.Stage
import com.example.adaptumapp.domain.repository.PlansRepository
import javax.inject.Inject

class PlansRepositoryImpl @Inject constructor(
    private val adaptListApi: AdaptListApi
) : PlansRepository {
    override suspend fun getAdaptPlans(): List<AdaptPlan> {
        return adaptListApi.getAdaptPlans().map { it.toModel() }
    }

    override suspend fun getStages(groupId: Int): List<Stage> {
        return adaptListApi.getStages(groupId).map { it.toModel() }
    }
}