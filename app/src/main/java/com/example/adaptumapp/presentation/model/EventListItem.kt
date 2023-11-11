package com.example.adaptumapp.presentation.model

import com.example.adaptumapp.domain.entity.Event

data class EventListItem(
    val id: Int,
    val photoUrl: String,
    val status: String,
    val title: String,
    val description: String,
    val date: String,
) {
    companion object {
        fun fromModel(event: Event) = EventListItem(
            id = event.id,
            photoUrl = event.photoUrl,
            status = event.status,
            title = event.title,
            description = event.description,
            date = event.date
        )
    }
}