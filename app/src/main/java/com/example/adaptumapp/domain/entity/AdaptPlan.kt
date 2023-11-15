package com.example.adaptumapp.domain.entity

data class AdaptPlan(
    val id: Int,
    val mentorId: Int,
    val groupName: String,
    val adaptPlanName: String,
    val countStages: Int,
    val countMentors: Int,
    val countMaterials: Int,
    val durationDays: Int,
    val avatarUrl: String,
    val startDate: String,
)