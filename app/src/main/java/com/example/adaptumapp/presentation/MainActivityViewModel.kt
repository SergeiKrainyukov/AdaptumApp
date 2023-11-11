package com.example.adaptumapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adaptumapp.domain.handler.TokenDataHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val tokenDataHandler: TokenDataHandler
) : ViewModel() {

    private val _isAuthorizedState = MutableSharedFlow<Boolean>()
    val isAuthorizedState: SharedFlow<Boolean>
        get() = _isAuthorizedState.asSharedFlow()

    fun checkUserAuthorized() {
        viewModelScope.launch {
            val tokenIsNotEmpty = tokenDataHandler.isTokenNotEmpty()
            _isAuthorizedState.emit(tokenIsNotEmpty)
        }
    }
}