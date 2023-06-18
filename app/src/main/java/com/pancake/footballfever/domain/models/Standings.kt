package com.pancake.footballfever.domain.models

import com.example.footboolfever.data.remote.dto.standings.Team


data class Standings(
    val rank:Int? =null,
    val team: Team? = null,
    val points: Int? = null,
    val win: Int? = null,
    val played:Int? = null
        )
