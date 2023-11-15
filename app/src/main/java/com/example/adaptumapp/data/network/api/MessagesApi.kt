package com.example.adaptumapp.data.network.api

import com.example.adaptumapp.data.network.dto.MessageDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MessagesApi {
    @GET("api/chat/contacts/{contactId}/talks/")
    suspend fun getMessages(@Path("contactId") contactId: Int): List<MessageDto>
}