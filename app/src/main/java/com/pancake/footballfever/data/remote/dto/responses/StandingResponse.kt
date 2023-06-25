package com.pancake.footballfever.data.remote.dto.responses

import com.example.footboolfever.data.remote.dto.standings.StandingsDto
import com.example.footboolfever.data.remote.dto.standings.StandingsParameters
import com.google.gson.annotations.SerializedName

data class StandingsResponse(

    @field:SerializedName("response")
    val response: List<StandingsDto?>? = null,

    @field:SerializedName("parameters")
    val parameters: StandingsParameters? = null,
)