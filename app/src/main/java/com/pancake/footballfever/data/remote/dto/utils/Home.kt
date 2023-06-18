package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Home(

    @field:SerializedName("winner")
    val winner: Boolean? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("logo")
    val logo: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
)
