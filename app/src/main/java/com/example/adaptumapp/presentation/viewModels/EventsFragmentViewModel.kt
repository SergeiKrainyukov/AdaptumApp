package com.example.adaptumapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import com.example.adaptumapp.presentation.model.EventListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class EventsFragmentViewModel @Inject constructor(
) : ViewModel() {

    private val _eventsState = MutableStateFlow<List<EventListItem>?>(null)
    val eventsState: StateFlow<List<EventListItem>?>
        get() = _eventsState.asStateFlow()

    fun init() {

    }

    fun onClickRegister(id: Int) {

    }
}