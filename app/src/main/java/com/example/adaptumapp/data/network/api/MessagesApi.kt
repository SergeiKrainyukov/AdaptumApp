package com.example.adaptumapp.data.network.api

import com.example.adaptumapp.data.network.dto.MessageDto
import retrofit2.http.GET

interface MessagesApi {
    @GET("api/chat/contacts/6/talks/")
    suspend fun getMessages(): List<MessageDto>
}