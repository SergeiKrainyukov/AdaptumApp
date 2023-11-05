package com.example.adaptumapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adaptumapp.presentation.model.TaskListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class TasksFragmentViewModel @Inject constructor() : ViewModel() {

    private val _tasksState = MutableStateFlow<List<TaskListItem>?>(null)
    val tasksState: StateFlow<List<TaskListItem>?>
        get() = _tasksState


    fun init() {
        viewModelScope.launch {
        val list = listOf(
            TaskListItem(
                0,
                type = "Бег",
                date = "10.10.2023",
                status = "К выполнению"
            ),
            TaskListItem(
                1,
                type = "Ходьба",
                date = "11.11.2023",
                status = "К выполнению"
            ),
        )
            _tasksState.emit(list)
        }
    }
}