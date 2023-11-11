package com.example.adaptumapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adaptumapp.domain.useCase.GetStagesUseCase
import com.example.adaptumapp.presentation.model.StageListItem
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class StagesFragmentViewModel @Inject constructor(
    private val getStagesUseCase: GetStagesUseCase
) : ViewModel() {

    private val _stagesState = MutableSharedFlow<List<StageListItem>>()
    val stagesState: SharedFlow<List<StageListItem>>
        get() = _stagesState

    fun init(groupId: Int) {
        viewModelScope.launch {
            try {
                val list = getStagesUseCase(groupId).map { StageListItem.fromModel(it) }
                _stagesState.emit(list)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}