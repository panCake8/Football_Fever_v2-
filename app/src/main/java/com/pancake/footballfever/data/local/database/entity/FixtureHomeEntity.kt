package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FIXTURE_TEAM_TABLE")
data class FixtureHomeEntity(
    @PrimaryKey
    val id: Int,
    val fixture: Int,
    val leagueName: String?,
    val round: String?,
    val elapsed: Int?,
    val timestamp: Long?,
    val homeTeamId: Int,
    val homeTeamName: String,
    val homeTeamLogo: String,
    val homeTeamGoals: Int,
    val awayTeamId: Int,
    val awayTeamName: String,
    val awayTeamLogo: String,
    val awayTeamGoals: Int
)
