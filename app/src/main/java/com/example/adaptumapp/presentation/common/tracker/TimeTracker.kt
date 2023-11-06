package com.example.adaptumapp.presentation.common.tracker

import kotlinx.coroutines.flow.StateFlow

interface TimeTracker {
    fun startTimer()
    fun stopTimer()
    fun pause()
    fun resume()
    fun listen(): StateFlow<Long>
    fun isRunning(): Boolean
}