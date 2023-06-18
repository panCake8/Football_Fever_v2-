package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Goals(

    @field:SerializedName("conceded")
    val conceded: Int? = null,

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("saves")
    val saves: Int? = null,

    @field:SerializedName("assists")
    val assists: Int? = null
)
