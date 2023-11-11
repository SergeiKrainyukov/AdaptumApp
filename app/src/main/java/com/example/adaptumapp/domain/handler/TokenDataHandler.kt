package com.example.adaptumapp.domain.handler

import com.example.adaptumapp.domain.entity.Token

interface TokenDataHandler {
    fun saveToken(token: Token)
    fun getToken(): Token
    fun isTokenEmpty(): Boolean
    fun isTokenNotEmpty(): Boolean
}