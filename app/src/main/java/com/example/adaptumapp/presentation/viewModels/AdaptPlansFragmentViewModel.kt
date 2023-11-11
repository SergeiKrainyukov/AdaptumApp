package com.example.adaptumapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adaptumapp.domain.useCase.GetAdaptListUseCase
import com.example.adaptumapp.presentation.model.AdaptPlanListItem
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


class AdaptPlansFragmentViewModel @Inject constructor(
    private val getAdaptListUseCase: GetAdaptListUseCase
) : ViewModel() {

    private var _adaptListState = MutableSharedFlow<List<AdaptPlanListItem>>()
    val adaptListState: SharedFlow<List<AdaptPlanListItem>>
        get() = _adaptListState.asSharedFlow()

    fun init() {
        viewModelScope.launch {
            try {
                val plans = getAdaptListUseCase().map { AdaptPlanListItem.fromModel(it) }
                _adaptListState.emit(plans)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}