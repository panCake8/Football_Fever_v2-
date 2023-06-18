package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Penalty(

    @field:SerializedName("saved")
    val saved: Int? = null,

    @field:SerializedName("scored")
    val scored: Int? = null,

    @field:SerializedName("missed")
    val missed: Int? = null,

    @field:SerializedName("won")
    val won: Int? = null,

    @field:SerializedName("commited")
    val commited: Any? = null
)
