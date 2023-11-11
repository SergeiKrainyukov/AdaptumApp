package com.example.adaptumapp.domain.useCase

import com.example.adaptumapp.presentation.model.ProfileDataUI
import javax.inject.Inject

class GetProfileDataUseCase @Inject constructor() {
    suspend operator fun invoke() = ProfileDataUI(
        avatarUrl = "",
        name = "Анфиса Питонова",
        job = "Менеджер по маркетингу",
        organization = "ООО Адаптум",
        mail = "anpitonova@mail.ru",
        city = "Москва"
    )
}