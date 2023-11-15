package com.example.adaptumapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adaptumapp.domain.useCase.GetMessagesUseCase
import com.example.adaptumapp.presentation.model.MessageListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChatFragmentViewModel @Inject constructor(
    private val getMessagesUseCase: GetMessagesUseCase
) : ViewModel() {

    private val _messagesState = MutableStateFlow<List<MessageListItem>>(listOf())
    val messagesState: StateFlow<List<MessageListItem>>
        get() = _messagesState

    fun init() {
        viewModelScope.launch {
            val messages = getMessagesUseCase.invoke()
            _messagesState.value = messages.map { MessageListItem.fromModel(it) }
        }
    }
}