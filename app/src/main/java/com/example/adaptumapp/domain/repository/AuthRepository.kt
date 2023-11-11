package com.example.adaptumapp.domain.repository

import com.example.adaptumapp.domain.entity.TokenData
import com.example.adaptumapp.domain.entity.UserData
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun auth(userData: UserData): Flow<TokenData>
}