package com.example.adaptumapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import com.example.adaptumapp.presentation.model.MessageListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ChatFragmentViewModel @Inject constructor() : ViewModel() {

    private val _messagesState = MutableStateFlow<List<MessageListItem>>(listOf())
    val messagesState: StateFlow<List<MessageListItem>>
        get() = _messagesState

    fun init() {
        _messagesState.value = listOf(
            MessageListItem("Привет, нужна помощь по первой стадии плана", true),
            MessageListItem("Привет, освобожусь в 12:00, тогда пообщаемся", false),
            MessageListItem("Хорошо, договорились", true),
        )
    }
}