package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Fouls(

    @field:SerializedName("committed")
    val committed: Int? = null,

    @field:SerializedName("drawn")
    val drawn: Int? = null
)
