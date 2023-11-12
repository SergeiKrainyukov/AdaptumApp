package com.example.adaptumapp.domain.repository

import com.example.adaptumapp.domain.entity.AdaptPlan
import com.example.adaptumapp.domain.entity.StageMin

interface PlansRepository {
    suspend fun getAdaptPlans(): List<AdaptPlan>
    suspend fun getStages(groupId: Int): List<StageMin>
}