package com.example.adaptumapp.domain.useCase

import com.example.adaptumapp.domain.entity.MessageBody
import com.example.adaptumapp.domain.repository.MessagesRepository
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(
    private val messagesRepository: MessagesRepository
) {
    suspend operator fun invoke(message: MessageBody) {
        messagesRepository.sendMessage(message)
    }
}