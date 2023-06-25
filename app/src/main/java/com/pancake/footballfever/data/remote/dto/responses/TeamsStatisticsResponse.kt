package com.pancake.footballfever.data.remote.dto.responses

import com.example.footboolfever.data.remote.dto.teams.TeamsStatisticsDto
import com.google.gson.annotations.SerializedName

data class TeamsStatisticsResponse(

    @field:SerializedName("response")
    val response: TeamsStatisticsDto? = null,
)