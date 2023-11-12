package com.example.adaptumapp.domain.useCase

import com.example.adaptumapp.domain.repository.AuthRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authRepository: AuthRepository
){
    operator fun invoke() = authRepository.logout()
}