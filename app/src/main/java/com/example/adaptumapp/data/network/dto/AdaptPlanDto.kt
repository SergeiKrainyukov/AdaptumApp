package com.example.adaptumapp.data.network.dto

import com.example.adaptumapp.domain.entity.AdaptPlan
import com.google.gson.annotations.SerializedName

data class AdaptPlanDto(
    @SerializedName("id") val id: Int,
    @SerializedName("mentor_info") val mentorInfoDto: MentorInfoDto,
    @SerializedName("group_info") val groupInfoDto: GroupInfoDto,
    @SerializedName("adapt_info") val adaptInfoDto: AdaptInfoDto,
    @SerializedName("statPlan") val statPlan: StatPlan,
){
    fun toModel() = AdaptPlan(
        id = id,
        groupName = groupInfoDto.title,
        adaptPlanName = adaptInfoDto.title,
        countStages = statPlan.countStages,
        countMentors = statPlan.countMentors,
        countMaterials = statPlan.countMaterials,
        durationDays = statPlan.durationDays,
        avatarUrl = mentorInfoDto.avatarUrl,
        startDate = groupInfoDto.startDate,
        mentorId = mentorInfoDto.id
    )
}

data class MentorInfoDto(
    @SerializedName("id") val id: Int,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("avatar") val avatarUrl: String,
)

data class GroupInfoDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("start_date") val startDate: String
)

data class AdaptInfoDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("start_date") val startDate: String
)

data class StatPlan(
    @SerializedName("id") val id: Int,
    @SerializedName("countStages") val countStages: Int,
    @SerializedName("countMentors") val countMentors: Int,
    @SerializedName("countMaterials") val countMaterials: Int,
    @SerializedName("durationDays") val durationDays: Int
)
