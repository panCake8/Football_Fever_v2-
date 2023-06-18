package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class ExtraTime(

    @field:SerializedName("away")
    val away: Any? = null,

    @field:SerializedName("home")
    val home: Any? = null
)
