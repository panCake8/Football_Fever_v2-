package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Substitutes(

    @field:SerializedName("bench")
    val bench: Int? = null,

    @field:SerializedName("in")
    val on: Int? = null,

    @field:SerializedName("out")
    val out: Int? = null
)
