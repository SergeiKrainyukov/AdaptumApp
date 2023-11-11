package com.example.adaptumapp.data.network.dto

import com.example.adaptumapp.domain.entity.Token

data class TokenDataDto(val token: String) {
    fun toDomainModel() = Token(token = token)
}