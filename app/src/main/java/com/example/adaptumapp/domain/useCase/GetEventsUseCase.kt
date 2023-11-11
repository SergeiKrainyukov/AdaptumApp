package com.example.adaptumapp.domain.useCase

import com.example.adaptumapp.domain.repository.EventsRepository
import javax.inject.Inject

class GetEventsUseCase @Inject constructor(
    private val eventsRepository: EventsRepository
) {
    suspend operator fun invoke() = eventsRepository.getEvents()
}