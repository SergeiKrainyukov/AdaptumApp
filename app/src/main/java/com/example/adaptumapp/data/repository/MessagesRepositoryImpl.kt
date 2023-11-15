package com.example.adaptumapp.data.repository

import com.example.adaptumapp.domain.entity.Message
import com.example.adaptumapp.domain.repository.MessagesRepository
import javax.inject.Inject

class MessagesRepositoryImpl @Inject constructor(): MessagesRepository {
    override suspend fun getMessages(): List<Message> {
        return listOf(
            Message(id = 0, "Привет, нужна помощь по первой стадии плана", true),
            Message(id = 1, "Привет, освобожусь в 12:00, тогда пообщаемся", false),
            Message(id = 2, "Хорошо, договорились", true),
        )
    }
}