package com.example.adaptumapp.domain.useCase

import com.example.adaptumapp.domain.repository.PlansRepository
import javax.inject.Inject

class GetAdaptListUseCase @Inject constructor(
    private val plansRepository: PlansRepository
) {
    suspend operator fun invoke() = plansRepository.getAdaptPlans()
}