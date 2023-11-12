package com.example.adaptumapp.data.network.dto

import com.example.adaptumapp.domain.entity.Stage
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.Locale

data class StageDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("updated_at") val date: String,
    @SerializedName("file") val documentUrl: String?,
    @SerializedName("link_video") val videoUrl: String?,
) {
    fun toModel() = Stage(
        id = id,
        name = title,
        description = description,
        date = parseDate(date),
        documentUrl = documentUrl ?: "",
        videoUrl = videoUrl ?: ""
    )

    private fun parseDate(dateDto: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return outputFormat.format(inputFormat.parse(dateDto)!!)
    }

}
