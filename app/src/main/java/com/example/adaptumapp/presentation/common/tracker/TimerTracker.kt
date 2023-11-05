package com.example.adaptumapp.presentation.common.tracker

import kotlinx.coroutines.flow.StateFlow

interface TimerTracker {
    fun startTimer()
    fun stopTimer()
    fun pause()
    fun resume()
    fun listen(): StateFlow<Long>
    fun isRunning(): Boolean
}