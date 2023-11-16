package com.example.adaptumapp.data.repository

import com.example.adaptumapp.data.network.api.AdaptListApi
import com.example.adaptumapp.domain.entity.AdaptPlan
import com.example.adaptumapp.domain.entity.Stage
import com.example.adaptumapp.domain.entity.UserDataOnStageKeys
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

    override suspend fun completeStage(
        timeSpent: Int,
        userDataOnStageKeys: UserDataOnStageKeys
    ) {
        adaptListApi.completeStage(
            id = userDataOnStageKeys.onboardingEventId,
            user = userDataOnStageKeys.user,
            userGroup = userDataOnStageKeys.userGroup,
            stage = userDataOnStageKeys.stage,
            timeSpent = timeSpent
        )
    }
}