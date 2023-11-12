package com.example.adaptumapp.presentation.model

import com.example.adaptumapp.domain.entity.StageFull

data class StageDataUI(
    val title: String,
    val description: String,
    val documentUrl: String,
    val videoUrl: String
) {
    companion object {
        fun fromModel(stageFull: StageFull) = StageDataUI(
            title = stageFull.title,
            description = stageFull.description,
            documentUrl = stageFull.documentUrl,
            videoUrl = stageFull.videoUrl,
        )
    }
}
