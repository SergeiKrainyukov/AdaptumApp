package com.example.adaptumapp.data.repository

import com.example.adaptumapp.data.network.api.ProfileDataApi
import com.example.adaptumapp.domain.entity.ProfileData
import com.example.adaptumapp.domain.repository.ProfileDataRepository
import javax.inject.Inject

class ProfileDataRepositoryImpl @Inject constructor(
    private val profileDataApi: ProfileDataApi
): ProfileDataRepository {
    override suspend fun getProfileData(): ProfileData {
        return profileDataApi.getProfileData().first().toModel()
    }

}