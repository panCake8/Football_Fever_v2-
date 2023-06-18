package com.example.footboolfever.data.remote.dto.responses

import com.example.footboolfever.data.remote.dto.teams.TeamsDto
import com.google.gson.annotations.SerializedName

data class TeamsResponse(

    @field:SerializedName("response")
    val response: List<TeamsDto?>? = null
)
