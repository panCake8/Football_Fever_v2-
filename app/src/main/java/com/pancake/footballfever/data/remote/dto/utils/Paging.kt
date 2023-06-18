package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Paging(
    @field:SerializedName("current")
    val current: Int? = null,

    @field:SerializedName("total")
    val total: Int? = null
)
