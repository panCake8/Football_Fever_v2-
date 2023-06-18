package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Venue(

    @field:SerializedName("city")
    val city: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
)
