package com.example.adaptumapp.presentation.common.tracker

import android.os.CountDownTimer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TimeTrackerImpl @Inject constructor() : TimeTracker, CountDownTimer(Long.MAX_VALUE, 1000) {

    private val timeState = MutableStateFlow(0L)
    private var elapsedTime = 0L
    private var isRunning = false

    override fun startTimer() {
        isRunning = true
        start()
    }

    override fun onTick(p0: Long) {
        elapsedTime += 1000
        timeState.value = elapsedTime / 1000
    }

    override fun onFinish() {
        isRunning = false
    }

    override fun stopTimer() {
        isRunning = false
        cancel()
    }

    override fun pause() {
        isRunning = false
        cancel()
    }

    override fun resume() {
        isRunning = true
        start()
    }

    override fun listen(): StateFlow<Long> = timeState

    override fun isRunning() = isRunning


}