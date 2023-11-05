package com.example.adaptumapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import com.example.adaptumapp.presentation.model.TaskListItem
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class TasksFragmentViewModel @Inject constructor() : ViewModel() {

    private val _trainingsState = MutableStateFlow<List<TaskListItem>?>(null)
    val trainingsState: MutableStateFlow<List<TaskListItem>?>
        get() = _trainingsState


    fun init() {

    }
}