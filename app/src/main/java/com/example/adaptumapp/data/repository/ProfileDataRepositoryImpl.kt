package com.example.adaptumapp.data.repository

import com.example.adaptumapp.domain.entity.ProfileData
import com.example.adaptumapp.domain.repository.ProfileDataRepository
import javax.inject.Inject

class ProfileDataRepositoryImpl @Inject constructor(): ProfileDataRepository {
    override suspend fun getProfileData(): ProfileData {
        return ProfileData(
            avatarUrl = "",
            name = "Анфиса Питонова",
            job = "Менеджер по маркетингу",
            organization = "ООО Адаптум",
            mail = "anpitonova@mail.ru",
            city = "Москва"
        )
    }

}