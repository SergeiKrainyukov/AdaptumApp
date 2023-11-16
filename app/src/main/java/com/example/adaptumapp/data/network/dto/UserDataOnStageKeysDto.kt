package com.example.adaptumapp.data.network.dto

import com.example.adaptumapp.domain.entity.UserDataOnStageKeys
import com.google.gson.annotations.SerializedName

data class UserDataOnStageKeysDto(
    @SerializedName("onboarding_event_id") val onboardingEventId: Int,
    @SerializedName("user") val user: Int,
    @SerializedName("user_group") val userGroup: Int,
    @SerializedName("stage") val stage: Int,
) {
    fun toModel() = UserDataOnStageKeys(onboardingEventId, user, userGroup, stage)
}
