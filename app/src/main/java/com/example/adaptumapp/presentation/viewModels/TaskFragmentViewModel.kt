package com.example.adaptumapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import com.example.adaptumapp.presentation.common.tracker.TimerTracker
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

class TaskFragmentViewModel @Inject constructor(
    private val timerTracker: TimerTracker,
) : ViewModel() {

    private val _timeCountState = MutableStateFlow<Long>(0)
    val timeCountState: StateFlow<Long>
        get() = _timeCountState

    private val _onPausedState = MutableStateFlow(false)
    val onPausedState: StateFlow<Boolean>
        get() = _onPausedState

    private val _closeScreenState = MutableStateFlow<Unit?>(null)
    val closeScreenState: StateFlow<Unit?>
        get() = _closeScreenState

    private var startDate = ""

    fun init() {
    }

    fun onClickStop() {

    }

    fun onClickPauseResume() {
        pauseResumeTimerTracker()
        _onPausedState.value = !_onPausedState.value
    }

    private fun pauseResumeTimerTracker() {
        if (timerTracker.isRunning()) {
            timerTracker.pause()
        } else {
            timerTracker.resume()
        }
    }

    private fun getCurrentDate(): String {
        val currentDateTime: Calendar = Calendar.getInstance()
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        return formatter.format(currentDateTime.time)
    }

    companion object {
        private const val UNIT_STEP = "step"
        private const val UNIT_KM = "km"
        private const val UNIT_MIN = "min"
    }
}