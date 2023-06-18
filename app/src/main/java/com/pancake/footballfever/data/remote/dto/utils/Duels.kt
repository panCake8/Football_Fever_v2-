package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Duels(

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("won")
    val won: Int? = null
)
