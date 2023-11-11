package com.example.adaptumapp.domain.handler

import com.example.adaptumapp.domain.entity.TokenData

interface TokenDataHandler {
    fun saveToken(tokenData: TokenData)
    fun getToken(): TokenData
    fun isTokenEmpty(): Boolean
    fun isTokenNotEmpty(): Boolean
}