package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GAME_LEAGUE_TABLE")
data class GameLeagueEntity(
    @PrimaryKey
    val id: Int? = 0,
    val name: String? = "",
    val logo: String? = "",
    val country: String? = "",
    val season: Int? = 0,
    val type: String? = "",
)
