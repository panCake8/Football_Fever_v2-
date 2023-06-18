package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Fixture(

    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("venue")
    val venue: Venue? = null,

    @field:SerializedName("timezone")
    val timezone: String? = null,

    @field:SerializedName("periods")
    val periods: Periods? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("referee")
    val referee: Any? = null,

    @field:SerializedName("timestamp")
    val timestamp: Int? = null,

    @field:SerializedName("status")
    val status: Status? = null
)

