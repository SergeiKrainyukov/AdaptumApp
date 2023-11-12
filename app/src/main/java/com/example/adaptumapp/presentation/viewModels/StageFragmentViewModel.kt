package com.example.adaptumapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adaptumapp.domain.useCase.GetStageUseCase
import com.example.adaptumapp.presentation.model.StageDataUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class StageFragmentViewModel @Inject constructor(
    private val getStageUseCase: GetStageUseCase
) : ViewModel() {

    private var _stageDataState = MutableStateFlow<StageDataUI?>(null)
    val stageDataState: StateFlow<StageDataUI?>
        get() = _stageDataState.asStateFlow()

    fun init() {
        viewModelScope.launch {
            val stage = StageDataUI.fromModel(getStageUseCase())
            _stageDataState.emit(stage)
        }
    }
}