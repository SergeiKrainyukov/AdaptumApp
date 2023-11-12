package com.example.adaptumapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adaptumapp.presentation.model.StageListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class StageFragmentViewModel @Inject constructor(
) : ViewModel() {

    private var _stageDataState = MutableStateFlow<StageListItem?>(null)
    val stageDataState: StateFlow<StageListItem?>
        get() = _stageDataState.asStateFlow()

    fun init(stageListItem: StageListItem) {
        viewModelScope.launch {
            _stageDataState.emit(stageListItem)
        }
    }
}