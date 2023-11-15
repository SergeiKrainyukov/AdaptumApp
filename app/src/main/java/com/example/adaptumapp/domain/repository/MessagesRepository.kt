package com.example.adaptumapp.domain.repository

import com.example.adaptumapp.domain.entity.Message

interface MessagesRepository {
    suspend fun getMessages(contactId: Int): List<Message>
}