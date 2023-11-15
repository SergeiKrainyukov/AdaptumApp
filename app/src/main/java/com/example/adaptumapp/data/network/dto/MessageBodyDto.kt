package com.example.adaptumapp.data.network.dto

import com.example.adaptumapp.domain.entity.MessageBody

data class MessageBodyDto(
    val message: String,
    val sender: Int,
    val recipient: Int
) {
    companion object {
        fun fromModel(message: MessageBody) = MessageBodyDto(
            message = message.message,
            sender = message.senderId,
            recipient = message.recipientId
        )
    }
}