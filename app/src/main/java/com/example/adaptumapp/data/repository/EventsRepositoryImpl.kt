package com.example.adaptumapp.data.repository

import com.example.adaptumapp.data.network.api.EventsApi
import com.example.adaptumapp.domain.entity.Event
import com.example.adaptumapp.domain.repository.EventsRepository
import javax.inject.Inject

class EventsRepositoryImpl @Inject constructor(
    private val eventsApi: EventsApi
) : EventsRepository {
    override suspend fun getEvents(): List<Event> {
        return eventsApi.getEvents().map { it.toModel() }
    }
}