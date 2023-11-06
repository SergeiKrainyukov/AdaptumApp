package com.example.adaptumapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adaptumapp.presentation.common.tracker.TimeTracker
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

class TaskFragmentViewModel @Inject constructor(
    private val timeTracker: TimeTracker,
) : ViewModel() {

    private val _timeCountState = MutableStateFlow<Long>(0)
    val timeCountState: StateFlow<Long>
        get() = _timeCountState

    private var _isStarted: Boolean = false
    val isStarted: Boolean
        get() = _isStarted

    fun init() {
        viewModelScope.launch {
            timeTracker.listen().collectLatest {
                _timeCountState.emit(it)
            }
        }

    }

    fun onClickStop() {

    }

    fun onClickPauseResume() {
        _isStarted = if (timeTracker.isRunning()) {
            timeTracker.pause()
            false
        } else {
            timeTracker.resume()
            true
        }
    }

    private fun getCurrentDate(): String {
        val currentDateTime: Calendar = Calendar.getInstance()
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        return formatter.format(currentDateTime.time)
    }
}