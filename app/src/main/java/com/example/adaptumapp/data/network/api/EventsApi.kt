package com.example.adaptumapp.data.network.api

import com.example.adaptumapp.data.network.dto.EventDto
import retrofit2.http.GET

interface EventsApi {
    @GET("api/events/all/")
    suspend fun getEvents(): List<EventDto>
}