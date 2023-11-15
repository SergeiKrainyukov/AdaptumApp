package com.example.adaptumapp.data.network.dto

import com.example.adaptumapp.domain.entity.Message

data class MessageDto(
    val id: Int,
    val message: String,
    val isMyMessage: Boolean
) {
    fun toModel() = Message(id, message, isMyMessage)
}
