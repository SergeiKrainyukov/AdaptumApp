package com.example.adaptumapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adaptumapp.domain.entity.UserData
import com.example.adaptumapp.domain.useCase.LoginUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginFragmentViewModel @Inject constructor(
    private var loginUseCase: LoginUseCase
) : ViewModel() {

    private val _authStatusState = MutableSharedFlow<Boolean>()
    val authStatusState: SharedFlow<Boolean>
        get() = _authStatusState.asSharedFlow()

    fun onClickAuth(username: String?, password: String?) {
        viewModelScope.launch {
            if (username.isNullOrBlank() || password.isNullOrBlank())
                _authStatusState.emit(false)
            else
                loginUseCase.auth(UserData(username, password)).collectLatest {
                    _authStatusState.emit(it.token.isNotBlank())
                }

        }
    }
}