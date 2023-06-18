package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Passes(

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("accuracy")
    val accuracy: Any? = null,

    @field:SerializedName("key")
    val key: Int? = null
)
