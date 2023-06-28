package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity

@Entity(tableName = "TOP_PLAYERS_GOAL_TABLE", primaryKeys = ["season","teamId", "LeagueId"])
data class TopGoalsEntity(
    val teamId: Int,
    val season: Int,
    val LeagueId: Int,
    val playerName: String? = "",
    val teamName: String? = "",
    val totalGoals: Int? = 0,
    val playerImg: String? = ""
)