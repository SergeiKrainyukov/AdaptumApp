package com.example.adaptumapp.presentation.model

import com.example.adaptumapp.domain.entity.AdaptPlan
import com.example.adaptumapp.domain.entity.MentorInfo

data class AdaptPlanListItem(
    val id: Int,
    val mentor: MentorInfo,
    val groupName: String,
    val adaptPlanName: String,
    val countStages: String,
    val countMentors: String,
    val countMaterials: String,
    val durationDays: String,
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
            mentor = adaptPlan.mentor,
            startDate = adaptPlan.startDate
        )
    }
}