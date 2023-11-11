package com.example.adaptumapp.data.repository

import com.example.adaptumapp.domain.entity.Event
import com.example.adaptumapp.domain.repository.EventsRepository
import javax.inject.Inject

class EventsRepositoryImpl @Inject constructor(): EventsRepository {
    override suspend fun getEvents(): List<Event> {
        TODO("Not yet implemented")
    }
}