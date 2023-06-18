package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class HalfTime(

    @field:SerializedName("away")
    val away: Int? = null,

    @field:SerializedName("home")
    val home: Int? = null
)