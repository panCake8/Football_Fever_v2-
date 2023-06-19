package com.pancake.footballfever.domain.models

import com.example.footboolfever.data.remote.dto.standings.Team
import com.google.gson.annotations.SerializedName


data class Standings(
    val rank:Int? =null,
    val teamName: String? = null,
    val teamLogoUrl: String? = null,
    val teamId: Int? = null,
    val points: Int? = null,
    val win: Int? = null,
    val played:Int? = null
        )
