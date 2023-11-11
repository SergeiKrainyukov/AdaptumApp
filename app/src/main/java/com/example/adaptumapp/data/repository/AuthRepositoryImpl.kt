package com.example.adaptumapp.data.repository

import com.example.adaptumapp.data.network.api.AuthApi
import com.example.adaptumapp.domain.entity.Token
import com.example.adaptumapp.domain.entity.User
import com.example.adaptumapp.domain.handler.TokenDataHandler
import com.example.adaptumapp.domain.repository.AuthRepository
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Named

class AuthRepositoryImpl @Inject constructor(
    @Named("NoAuthInterceptor")
    private val authApi: AuthApi,
    private val tokenDataHandler: TokenDataHandler
) : AuthRepository {

    private fun saveTokenData(token: Token) {
        tokenDataHandler.saveToken(token)
    }

    override fun auth(user: User) = flow {
        try {
            val tokenDataDto = authApi.auth(user)
            saveTokenData(tokenDataDto.toDomainModel())
            emit(tokenDataDto.toDomainModel())
        } catch (e: Exception) {
            emit(Token(""))
        }
    }


}