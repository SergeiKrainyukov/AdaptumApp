package com.example.adaptumapp.domain.repository

import com.example.adaptumapp.domain.entity.AdaptPlan

interface AdaptListRepository {
    suspend fun getAdaptPlans(): List<AdaptPlan>
}