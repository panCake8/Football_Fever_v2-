package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TOP_PLAYERS_GOAL_TABLE")
data class TopGoalsEntity(
    @PrimaryKey
    val id: Int? = 0,
    val playerName: String? = "",
    val teamName: String? = "",
    val totalGoals: Int? = 0,
    val playerImg: String? = ""
)