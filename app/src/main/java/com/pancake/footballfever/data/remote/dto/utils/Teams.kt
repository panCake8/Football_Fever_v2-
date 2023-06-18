package com.example.footboolfever.data.remote.dto.utils


import com.google.gson.annotations.SerializedName

data class Teams(

    @field:SerializedName("away")
    val away: Away? = null,

    @field:SerializedName("home")
    val home: Home? = null
)
