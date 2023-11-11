package com.example.adaptumapp.di.modules

import com.example.adaptumapp.data.handler.TokenDataHandlerImpl
import com.example.adaptumapp.domain.handler.TokenDataHandler
import com.example.adaptumapp.presentation.common.tracker.TimeTracker
import com.example.adaptumapp.presentation.common.tracker.TimeTrackerImpl
import dagger.Binds
import dagger.Module

@Module
abstract class HandlersModule {
    @Binds
    abstract fun provideTimerTracker(timerTracker: TimeTrackerImpl): TimeTracker

    @Binds
    abstract fun provideTokenDataHandler(tokenDataHandler: TokenDataHandlerImpl): TokenDataHandler
}