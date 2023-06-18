package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Birth(

    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("country")
    val country: String? = null,

    @field:SerializedName("place")
    val place: String? = null
)
