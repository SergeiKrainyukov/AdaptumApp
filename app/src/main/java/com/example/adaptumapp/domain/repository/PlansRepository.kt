package com.example.adaptumapp.domain.repository

import com.example.adaptumapp.domain.entity.AdaptPlan
import com.example.adaptumapp.domain.entity.Stage

interface PlansRepository {
    suspend fun getAdaptPlans(): List<AdaptPlan>
    suspend fun getStages(): List<Stage>
}