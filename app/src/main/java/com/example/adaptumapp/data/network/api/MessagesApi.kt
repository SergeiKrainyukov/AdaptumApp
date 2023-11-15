package com.example.adaptumapp.data.network.api

import com.example.adaptumapp.data.network.dto.MessageDto
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface MessagesApi {
    @GET("api/chat/contacts/{contactId}/talks/")
    suspend fun getMessages(@Path("contactId") contactId: Int): List<MessageDto>

    @Multipart
    @POST("/api/chat/")
    suspend fun sendMessage(
        @Part("message") message: String,
        @Part("sender") sender: Int,
        @Part("recipient") recipient: Int,
    )
}