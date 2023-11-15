package com.example.adaptumapp.domain.entity

data class MessageBody(
    val senderId: Int,
    val recipientId: Int,
    val message: String
)
