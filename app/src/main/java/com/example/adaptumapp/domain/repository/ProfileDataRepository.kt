package com.example.adaptumapp.domain.repository

import com.example.adaptumapp.domain.entity.ProfileData

interface ProfileDataRepository {
    suspend fun getProfileData(): ProfileData
}