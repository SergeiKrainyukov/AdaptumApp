package com.example.adaptumapp.domain.useCase

import com.example.adaptumapp.domain.repository.ProfileDataRepository
import javax.inject.Inject

class GetProfileDataUseCase @Inject constructor(
    private val profileDataRepository: ProfileDataRepository
) {
    suspend operator fun invoke() = profileDataRepository.getProfileData()
}