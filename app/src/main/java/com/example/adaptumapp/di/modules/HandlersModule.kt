package com.example.adaptumapp.di.modules

import com.example.adaptumapp.presentation.common.tracker.TimerTracker
import com.example.adaptumapp.presentation.common.tracker.TimerTrackerImpl
import dagger.Binds
import dagger.Module

@Module
abstract class HandlersModule {
    @Binds
    abstract fun provideTimerTracker(timerTracker: TimerTrackerImpl): TimerTracker
}