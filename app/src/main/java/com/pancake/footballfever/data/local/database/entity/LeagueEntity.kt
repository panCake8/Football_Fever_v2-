package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "LEAGUE_TABLE")
data class LeagueEntity(
    @PrimaryKey
    val id: Int? = 0,
    val name: String? = "",
    val logo: String? = "",
    val type: String? = "",
)
