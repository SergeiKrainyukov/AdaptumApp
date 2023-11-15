package com.example.adaptumapp.presentation.model

import com.example.adaptumapp.domain.entity.AdaptPlan

data class AdaptPlanListItem(
    val id: Int,
    val mentorId: Int,
    val groupName: String,
    val adaptPlanName: String,
    val countStages: String,
    val countMentors: String,
    val countMaterials: String,
    val durationDays: String,
    val avatarUrl: String,
    val startDate: String
) {
    companion object {
        fun fromModel(adaptPlan: AdaptPlan) = AdaptPlanListItem(
            id = adaptPlan.id,
            groupName = adaptPlan.groupName,
            adaptPlanName = adaptPlan.adaptPlanName,
            countStages = adaptPlan.countStages.toString(),
            countMentors = adaptPlan.countMentors.toString(),
            countMaterials = adaptPlan.countMaterials.toString(),
            durationDays = adaptPlan.durationDays.toString(),
            avatarUrl = adaptPlan.avatarUrl,
            mentorId = adaptPlan.mentorId,
            startDate = adaptPlan.startDate
        )
    }
}