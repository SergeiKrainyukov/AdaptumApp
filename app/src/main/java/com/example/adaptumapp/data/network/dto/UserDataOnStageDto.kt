package com.example.adaptumapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class UserDataOnStageDto(
    @SerializedName("status_txt") val status: String
)
