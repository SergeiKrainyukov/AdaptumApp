package com.example.adaptumapp.domain.repository

import com.example.adaptumapp.domain.entity.Event

interface EventsRepository {
    suspend fun getEvents(): List<Event>
}