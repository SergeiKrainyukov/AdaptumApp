package com.example.adaptumapp.presentation.model

data class EventListItem(
    val id: Int,
    val status: String,
    val title: String,
    val description: String,
    val units: Int,
    val date: String,
)