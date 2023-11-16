package com.example.adaptumapp.domain.useCase

import com.example.adaptumapp.domain.entity.UserDataOnStageKeys
import com.example.adaptumapp.domain.repository.PlansRepository
import javax.inject.Inject

class CompleteStageUseCase @Inject constructor(
    private val plansRepository: PlansRepository
) {
    suspend fun invoke(
        timeSpent: Int,
        userDataOnStageKeys: UserDataOnStageKeys
    ) = plansRepository.completeStage(timeSpent, userDataOnStageKeys)
}