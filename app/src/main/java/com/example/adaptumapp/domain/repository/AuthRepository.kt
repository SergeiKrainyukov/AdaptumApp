package com.example.adaptumapp.domain.repository

import com.example.adaptumapp.domain.entity.Token
import com.example.adaptumapp.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun auth(user: User): Flow<Token>
    fun logout()
}