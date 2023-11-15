package com.example.adaptumapp.di.modules

import com.example.adaptumapp.data.repository.PlansRepositoryImpl
import com.example.adaptumapp.data.repository.AuthRepositoryImpl
import com.example.adaptumapp.data.repository.EventsRepositoryImpl
import com.example.adaptumapp.data.repository.MessagesRepositoryImpl
import com.example.adaptumapp.data.repository.ProfileDataRepositoryImpl
import com.example.adaptumapp.domain.repository.PlansRepository
import com.example.adaptumapp.domain.repository.AuthRepository
import com.example.adaptumapp.domain.repository.EventsRepository
import com.example.adaptumapp.domain.repository.MessagesRepository
import com.example.adaptumapp.domain.repository.ProfileDataRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideAuthRepository(repository: AuthRepositoryImpl): AuthRepository

    @Binds
    abstract fun provideProfileDataRepository(repository: ProfileDataRepositoryImpl): ProfileDataRepository

    @Binds
    abstract fun provideEventsRepository(repository: EventsRepositoryImpl): EventsRepository

    @Binds
    abstract fun provideMessagesRepository(repository: MessagesRepositoryImpl): MessagesRepository

    @Binds
    abstract fun provideAdaptListRepository(adaptListRepositoryImpl: PlansRepositoryImpl): PlansRepository
}