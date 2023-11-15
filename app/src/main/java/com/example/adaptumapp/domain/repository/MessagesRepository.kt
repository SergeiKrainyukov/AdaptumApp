package com.example.adaptumapp.domain.repository

import com.example.adaptumapp.domain.entity.Message
import com.example.adaptumapp.domain.entity.MessageBody

interface MessagesRepository {
    suspend fun getMessages(contactId: Int): List<Message>
    suspend fun sendMessage(message: MessageBody)
}