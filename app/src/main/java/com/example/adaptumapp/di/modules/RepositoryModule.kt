package com.example.adaptumapp.di.modules

import com.example.adaptumapp.data.repository.AdaptListRepositoryImpl
import com.example.adaptumapp.data.repository.AuthRepositoryImpl
import com.example.adaptumapp.domain.repository.AdaptListRepository
import com.example.adaptumapp.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideAuthRepository(repository: AuthRepositoryImpl): AuthRepository

    @Binds
    abstract fun provideAdaptListRepository(adaptListRepositoryImpl: AdaptListRepositoryImpl): AdaptListRepository
}