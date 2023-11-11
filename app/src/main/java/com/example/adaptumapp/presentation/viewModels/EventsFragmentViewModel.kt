package com.example.adaptumapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adaptumapp.domain.useCase.GetEventsUseCase
import com.example.adaptumapp.presentation.model.EventListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class EventsFragmentViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase
) : ViewModel() {

    private val _eventsState = MutableStateFlow<List<EventListItem>?>(null)
    val eventsState: StateFlow<List<EventListItem>?>
        get() = _eventsState.asStateFlow()

    fun init() {
        viewModelScope.launch {
            val list = getEventsUseCase()
            _eventsState.emit(list)
        }
    }

    fun onClickRegister(id: Int) {

    }
}