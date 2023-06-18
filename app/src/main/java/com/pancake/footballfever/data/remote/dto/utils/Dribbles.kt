package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Dribbles(

    @field:SerializedName("success")
    val success: Int? = null,

    @field:SerializedName("past")
    val past: Any? = null,

    @field:SerializedName("attempts")
    val attempts: Int? = null
)