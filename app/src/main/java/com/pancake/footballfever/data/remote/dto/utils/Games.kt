package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Games(

    @field:SerializedName("number")
    val number: Any? = null,

    @field:SerializedName("minutes")
    val minutes: Int? = null,

    @field:SerializedName("rating")
    val rating: String? = null,

    @field:SerializedName("appearences")
    val appearences: Int? = null,

    @field:SerializedName("position")
    val position: String? = null,

    @field:SerializedName("captain")
    val captain: Boolean? = null,

    @field:SerializedName("lineups")
    val lineups: Int? = null
)
