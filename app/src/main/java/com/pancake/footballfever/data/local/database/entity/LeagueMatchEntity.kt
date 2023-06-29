package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pancake.footballfever.domain.models.LeagueMatch

@Entity("LEAGUE_MATCH_TABLE", primaryKeys = ["season","teamId", "id"])
data class LeagueMatchEntity(
    val id: Int,
    val season: Int,
    val teamId: Int,
    val homeTeamName: String?,
    val homeTeamLogo: String?,
    val awayTeamName: String?,
    val awayTeamLogo: String?,
    val date: String?,
    val matchTime: String?,
)


