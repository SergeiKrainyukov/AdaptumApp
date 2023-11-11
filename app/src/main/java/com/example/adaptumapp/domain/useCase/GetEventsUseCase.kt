package com.example.adaptumapp.domain.useCase

import com.example.adaptumapp.domain.entity.Event
import com.example.adaptumapp.domain.repository.EventsRepository
import javax.inject.Inject

class GetEventsUseCase @Inject constructor(
    private val eventsRepository: EventsRepository
) {
    suspend operator fun invoke() = listOf(
        Event(
            id = 0,
            photoUrl = "",
            status = "Планируется",
            title = "День здоровья 1",
            description = "Описание события 1",
            date = "10.10.2023"
        ),
        Event(
            id = 1,
            photoUrl = "",
            status = "Планируется",
            title = "День здоровья 2",
            description = "Описание события 2",
            date = "12.11.2023"
        ),
    )
}