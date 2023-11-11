package com.example.adaptumapp.domain.useCase

import com.example.adaptumapp.domain.repository.AdaptListRepository
import javax.inject.Inject

class GetAdaptListUseCase @Inject constructor(
    private val adaptListRepository: AdaptListRepository
) {
    suspend operator fun invoke() = adaptListRepository.getAdaptPlans()
}