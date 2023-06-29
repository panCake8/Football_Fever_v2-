package com.example.footboolfever.data.remote.dto

import com.example.footboolfever.data.remote.dto.utils.Goals
import com.example.footboolfever.data.remote.dto.utils.League
import com.example.footboolfever.data.remote.dto.utils.Team
import com.google.gson.annotations.SerializedName

data class StatisticsDto(

    @field:SerializedName("team")
    val team: Team? = null,

    @SerializedName("goals")
    val goals: Goals? = null,

    @SerializedName("league")
    val league: League? = null,

    @field:SerializedName("statistics")
    val statistics: List<StatisticsItem?>? = null
)

data class StatisticsItem(

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("value")
    val value: Int? = null
)






