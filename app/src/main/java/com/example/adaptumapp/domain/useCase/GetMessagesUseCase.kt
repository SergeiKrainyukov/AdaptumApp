package com.example.adaptumapp.domain.useCase

import com.example.adaptumapp.domain.entity.Message
import com.example.adaptumapp.domain.repository.MessagesRepository
import javax.inject.Inject

class GetMessagesUseCase @Inject constructor(
    private val messagesRepository: MessagesRepository
) {
    suspend operator fun invoke(): List<Message> {
        return messagesRepository.getMessages()
    }
}