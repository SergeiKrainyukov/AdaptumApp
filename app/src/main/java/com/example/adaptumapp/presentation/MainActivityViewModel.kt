package com.example.adaptumapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adaptumapp.domain.handler.TokenDataHandler
import com.example.adaptumapp.domain.useCase.GetProfileDataUseCase
import com.example.adaptumapp.presentation.model.ProfileDataUI
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val tokenDataHandler: TokenDataHandler,
    private val getProfileDataUseCase: GetProfileDataUseCase
) : ViewModel() {

    private val _isAuthorizedState = MutableSharedFlow<Boolean>()
    val isAuthorizedState: SharedFlow<Boolean>
        get() = _isAuthorizedState.asSharedFlow()

    private var _profileDataState = MutableStateFlow<ProfileDataUI?>(null)
    val profileDataState: StateFlow<ProfileDataUI?>
        get() = _profileDataState.asStateFlow()

    fun checkUserAuthorized() {
        viewModelScope.launch {
            val tokenIsNotEmpty = tokenDataHandler.isTokenNotEmpty()
            _isAuthorizedState.emit(tokenIsNotEmpty)
        }
    }

    fun getProfileData() {
        viewModelScope.launch {
            try {
                val profileData = getProfileDataUseCase()
                _profileDataState.emit(ProfileDataUI.fromProfileData(profileData))
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}