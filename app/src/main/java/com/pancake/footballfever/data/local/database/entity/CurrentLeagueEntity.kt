package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CURRENT_LEAGUE_TABLE")
data class CurrentLeagueEntity(
    @PrimaryKey
    val id: Int? = 0,
    val name: String? = "",
    val logo: String? = "",
    val country: String? = "",
    val season: Int? = 0,
    val type: String? = "",
)
