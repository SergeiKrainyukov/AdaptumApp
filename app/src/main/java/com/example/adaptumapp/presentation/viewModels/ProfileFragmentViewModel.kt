package com.example.adaptumapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adaptumapp.domain.useCase.GetProfileDataUseCase
import com.example.adaptumapp.presentation.model.ProfileDataUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class ProfileFragmentViewModel @Inject constructor(
    private val getProfileDataUseCase: GetProfileDataUseCase
) : ViewModel() {

    private var _profileDataState = MutableStateFlow<ProfileDataUI?>(null)
    val profileDataState: StateFlow<ProfileDataUI?>
        get() = _profileDataState.asStateFlow()

    fun init() {
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