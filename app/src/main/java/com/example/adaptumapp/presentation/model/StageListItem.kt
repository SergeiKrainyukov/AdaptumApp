package com.example.adaptumapp.presentation.model

import com.example.adaptumapp.domain.entity.Stage

data class StageListItem(
    val id: Int,
    val name: String,
    val description: String,
    val date: String,
) {
    companion object {
        fun fromModel(stage: Stage) = StageListItem(
            id = stage.id,
            name = stage.name,
            description = stage.description,
            date = stage.date
        )
    }
}