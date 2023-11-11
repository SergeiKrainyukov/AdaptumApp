package com.example.adaptumapp.di.modules

import com.example.adaptumapp.data.repository.PlansRepositoryImpl
import com.example.adaptumapp.data.repository.AuthRepositoryImpl
import com.example.adaptumapp.domain.repository.PlansRepository
import com.example.adaptumapp.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideAuthRepository(repository: AuthRepositoryImpl): AuthRepository

    @Binds
    abstract fun provideAdaptListRepository(adaptListRepositoryImpl: PlansRepositoryImpl): PlansRepository
}