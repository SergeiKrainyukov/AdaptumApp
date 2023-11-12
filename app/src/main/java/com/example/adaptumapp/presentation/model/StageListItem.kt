package com.example.adaptumapp.presentation.model

import com.example.adaptumapp.domain.entity.StageMin

data class StageListItem(
    val id: Int,
    val name: String,
    val description: String,
    val date: String,
) {
    companion object {
        fun fromModel(stageMin: StageMin) = StageListItem(
            id = stageMin.id,
            name = stageMin.name,
            description = stageMin.description,
            date = stageMin.date
        )
    }
}