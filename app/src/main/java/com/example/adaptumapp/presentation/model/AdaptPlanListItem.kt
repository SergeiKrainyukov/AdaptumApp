package com.example.adaptumapp.presentation.model

data class AdaptPlanListItem(
    val id: Int,
    val groupName: String,
    val adaptPlanName: String,
    val countStages: String,
    val countMentors: String,
    val countMaterials: String,
    val durationDays: String,
    val avatarUrl: String,
    val startDate: String
)