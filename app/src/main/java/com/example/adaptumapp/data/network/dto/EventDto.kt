package com.example.adaptumapp.data.network.dto

import com.example.adaptumapp.domain.entity.Event
import com.google.gson.annotations.SerializedName

data class EventDto(
    @SerializedName("id") val id: Int,
    @SerializedName("cover") val photoUrl: String,
    @SerializedName("status_txt") val status: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("start_date") val date: String,
) {
    fun toModel() = Event(id, photoUrl, status, title, description, date)
}
