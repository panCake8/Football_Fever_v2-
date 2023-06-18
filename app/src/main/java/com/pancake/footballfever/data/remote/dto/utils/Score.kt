package com.example.footboolfever.data.remote.dto.utils


import com.google.gson.annotations.SerializedName

data class Score(

    @field:SerializedName("halftime")
    val halftime: HalfTime? = null,

    @field:SerializedName("penalty")
    val penalty: Penalty? = null,

    @field:SerializedName("fulltime")
    val fulltime: FullTime? = null,

    @field:SerializedName("extratime")
    val extratime: ExtraTime? = null
)
