package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("LEAGUE_MATCH_TABLE")
data class LeagueMatchEntity(

    @PrimaryKey
    val id: Int?,
    val homeTeamName: String?,
    val homeTeamLogo: String?,
    val awayTeamName: String?,
    val awayTeamLogo: String?,
    val date: String?,
    val matchTime: String?,
    )
