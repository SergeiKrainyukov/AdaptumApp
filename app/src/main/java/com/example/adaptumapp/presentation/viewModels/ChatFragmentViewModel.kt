package com.example.adaptumapp.presentation.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adaptumapp.domain.entity.Message
import com.example.adaptumapp.domain.entity.MessageBody
import com.example.adaptumapp.domain.useCase.GetMessagesUseCase
import com.example.adaptumapp.domain.useCase.GetProfileDataUseCase
import com.example.adaptumapp.domain.useCase.SendMessageUseCase
import com.example.adaptumapp.presentation.model.MessageListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class ChatFragmentViewModel @Inject constructor(
    private val getMessagesUseCase: GetMessagesUseCase,
    private val sendMessageUseCase: SendMessageUseCase,
    private val getProfileDataUseCase: GetProfileDataUseCase
) : ViewModel() {

    private val _messagesState = MutableStateFlow<List<MessageListItem>>(listOf())
    val messagesState: StateFlow<List<MessageListItem>>
        get() = _messagesState

    fun getMessages(contactId: Int) {
        viewModelScope.launch {
            try {
                contactId.let {
                    val messages = getMessagesUseCase.invoke(it)
                    _messagesState.value = messages.map { MessageListItem.fromModel(it) }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun onClickSendMessage(messageText: String, contactId: Int) {
        viewModelScope.launch {
            try {
                val userId = getProfileDataUseCase.invoke().id
                val message = MessageBody(userId, contactId, messageText)
                sendMessageUseCase(message)
                getMessages(contactId)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}