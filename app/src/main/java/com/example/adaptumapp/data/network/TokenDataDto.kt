package com.example.adaptumapp.data.network

import com.example.adaptumapp.domain.entity.TokenData

data class TokenDataDto(val token: String) {
    fun toDomainModel() = TokenData(token = token)
}