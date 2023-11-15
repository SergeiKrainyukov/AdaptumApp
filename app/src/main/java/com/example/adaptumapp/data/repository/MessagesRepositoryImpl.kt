package com.example.adaptumapp.data.repository

import com.example.adaptumapp.data.network.api.MessagesApi
import com.example.adaptumapp.domain.entity.Message
import com.example.adaptumapp.domain.entity.MessageBody
import com.example.adaptumapp.domain.repository.MessagesRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject


class MessagesRepositoryImpl @Inject constructor(
    private val messagesApi: MessagesApi
) : MessagesRepository {
    override suspend fun getMessages(contactId: Int): List<Message> {
        return messagesApi.getMessages(contactId).map { it.toModel() }
    }

    override suspend fun sendMessage(message: MessageBody) {
        messagesApi.sendMessage(
            message = message.message.toRequestBody("text/plain".toMediaTypeOrNull()),
            sender = message.senderId,
            recipient = message.recipientId
        )
    }
}