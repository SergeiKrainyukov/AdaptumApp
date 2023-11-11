package com.example.adaptumapp.data.repository

import com.example.adaptumapp.data.network.AuthApi
import com.example.adaptumapp.domain.entity.TokenData
import com.example.adaptumapp.domain.entity.UserData
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

    private fun saveTokenData(tokenData: TokenData) {
        tokenDataHandler.saveToken(tokenData)
    }

    override fun auth(userData: UserData) = flow {
        try {
            val tokenDataDto = authApi.auth(userData)
            saveTokenData(tokenDataDto.toDomainModel())
            emit(tokenDataDto.toDomainModel())
        } catch (e: Exception) {
            emit(TokenData(""))
        }
    }


}