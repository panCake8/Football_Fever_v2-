package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class League(

    @field:SerializedName("country")
    val country: String? = null,

    @field:SerializedName("flag")
    val flag: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("logo")
    val logo: String? = null,

    @field:SerializedName("season")
    val season: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null
)