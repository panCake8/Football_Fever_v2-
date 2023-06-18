package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Team(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("logo")
    val logo: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
)
