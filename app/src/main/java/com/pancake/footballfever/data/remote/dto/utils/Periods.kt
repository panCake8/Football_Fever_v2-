package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Periods(

    @field:SerializedName("first")
    val first: Int? = null,

    @field:SerializedName("second")
    val second: Any? = null
)
