package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Status(

    @field:SerializedName("elapsed")
    val elapsed: Int? = null,

    @field:SerializedName("short")
    val jsonMemberShort: String? = null,

    @field:SerializedName("long")
    val jsonMemberLong: String? = null
)
