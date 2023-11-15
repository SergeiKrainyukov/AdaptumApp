package com.example.adaptumapp.presentation.model

import com.example.adaptumapp.domain.entity.Message

data class MessageListItem(val id: Int, val message: String, val isSent: Boolean) {
    companion object {
        fun fromModel(message: Message) = MessageListItem(
            id = message.id,
            message = message.messageText,
            isSent = message.isSent
        )
    }
}