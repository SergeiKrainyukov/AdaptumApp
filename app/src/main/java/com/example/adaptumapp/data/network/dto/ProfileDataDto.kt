package com.example.adaptumapp.data.network.dto

import com.example.adaptumapp.domain.entity.ProfileData
import com.google.gson.annotations.SerializedName

data class ProfileDataDto(
    @SerializedName("id") val id: Int,
    @SerializedName("avatar") val avatar: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("employee_position") val job: String,
    @SerializedName("company") val company: String,
    @SerializedName("email") val email: String,
) {
    fun toModel() = ProfileData(
        id = id,
        avatarUrl = avatar,
        name = fullName,
        job = job,
        organization = company,
        mail = email,
        city = "Москва"
    )
}
