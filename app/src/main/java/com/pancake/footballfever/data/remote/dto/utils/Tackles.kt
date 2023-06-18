package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Tackles(

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("blocks")
    val blocks: Int? = null,

    @field:SerializedName("interceptions")
    val interceptions: Int? = null
)
