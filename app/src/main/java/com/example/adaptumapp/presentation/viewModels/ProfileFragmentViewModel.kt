package com.example.adaptumapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adaptumapp.presentation.model.ProfileDataUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfileFragmentViewModel @Inject constructor() : ViewModel() {

    private var _profileDataState = MutableStateFlow<ProfileDataUI?>(null)
    val profileDataState: StateFlow<ProfileDataUI?>
        get() = _profileDataState.asStateFlow()

    fun init() {
        viewModelScope.launch {
            val profileDataUI = ProfileDataUI(
                avatarUrl = "",
                name = "Анфиса Питонова",
                job = "Менеджер по маркетингу",
                organization = "ООО Адаптум",
                mail = "anpitonova@mail.ru",
                city = "Москва"
            )
            _profileDataState.emit(profileDataUI)
        }
    }
}