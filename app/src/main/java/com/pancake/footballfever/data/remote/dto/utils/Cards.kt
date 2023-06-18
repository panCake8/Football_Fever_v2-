package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Cards(

    @field:SerializedName("red")
    val red: Int? = null,

    @field:SerializedName("yellowred")
    val yellowred: Int? = null,

    @field:SerializedName("yellow")
    val yellow: Int? = null
)
