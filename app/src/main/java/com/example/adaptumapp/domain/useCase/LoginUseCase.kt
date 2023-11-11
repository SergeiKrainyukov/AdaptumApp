package com.example.adaptumapp.domain.useCase

import com.example.adaptumapp.domain.entity.UserData
import com.example.adaptumapp.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    fun auth(userData: UserData) =
        authRepository.auth(userData)

}