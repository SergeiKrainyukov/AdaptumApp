package com.example.adaptumapp.presentation.model

import com.example.adaptumapp.domain.entity.ProfileData

data class ProfileDataUI(
    val avatarUrl: String,
    val name: String,
    val job: String,
    val organization: String,
    val mail: String,
    val city: String,
){
    companion object {
        fun fromProfileData(profileData: ProfileData) = ProfileDataUI(
            avatarUrl = profileData.avatarUrl,
            name = profileData.name,
            job = profileData.job,
            organization = profileData.organization,
            mail = profileData.mail,
            city = profileData.city,
        )
    }
}
