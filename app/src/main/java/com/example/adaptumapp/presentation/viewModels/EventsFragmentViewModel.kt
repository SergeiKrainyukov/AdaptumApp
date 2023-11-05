package com.example.adaptumapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adaptumapp.presentation.model.EventListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class EventsFragmentViewModel @Inject constructor(
) : ViewModel() {

    private val _eventsState = MutableStateFlow<List<EventListItem>?>(null)
    val eventsState: StateFlow<List<EventListItem>?>
        get() = _eventsState.asStateFlow()

    fun init() {
        viewModelScope.launch {
            val list = listOf(
                EventListItem(
                    id = 0,
                    photoUrl = "",
                    status = "Планируется",
                    title = "День здоровья 1",
                    description = "Описание события 1",
                    date = "10.10.2023"
                ),
                EventListItem(
                    id = 1,
                    photoUrl = "",
                    status = "Планируется",
                    title = "День здоровья 2",
                    description = "Описание события 2",
                    date = "12.11.2023"
                ),
            )
            _eventsState.emit(list)
        }
    }

    fun onClickRegister(id: Int) {

    }
}