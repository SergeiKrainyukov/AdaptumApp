package com.example.adaptumapp.domain.repository

import com.example.adaptumapp.domain.entity.AdaptPlan
import com.example.adaptumapp.domain.entity.Stage
import com.example.adaptumapp.domain.entity.UserDataOnStageKeys

interface PlansRepository {
    suspend fun getAdaptPlans(): List<AdaptPlan>
    suspend fun getStages(groupId: Int): List<Stage>
    suspend fun completeStage(
        timeSpent: Int,
        userDataOnStageKeys: UserDataOnStageKeys
    )
}