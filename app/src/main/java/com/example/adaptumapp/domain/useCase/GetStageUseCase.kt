package com.example.adaptumapp.domain.useCase

import com.example.adaptumapp.domain.repository.PlansRepository
import javax.inject.Inject

class GetStageUseCase @Inject constructor(
    private val plansRepository: PlansRepository
) {
    operator suspend fun invoke(stageId: Int) = plansRepository.getStage(stageId)
}