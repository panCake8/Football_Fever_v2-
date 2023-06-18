package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Shots(

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("on")
    val on: Int? = null
)
