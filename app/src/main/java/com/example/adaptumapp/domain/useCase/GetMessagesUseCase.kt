package com.example.adaptumapp.domain.useCase

import com.example.adaptumapp.domain.entity.Message
import javax.inject.Inject

class GetMessagesUseCase @Inject constructor() {
    suspend operator fun invoke(): List<Message> {
        return listOf(
            Message(id = 0, "Привет, нужна помощь по первой стадии плана", true),
            Message(id = 1, "Привет, освобожусь в 12:00, тогда пообщаемся", false),
            Message(id = 2, "Хорошо, договорились", true),
        )
    }
}