package com.example.adaptumapp.domain.repository

import com.example.adaptumapp.domain.entity.Message

interface MessagesRepository {
    suspend fun getMessages(): List<Message>
}