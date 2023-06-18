package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TOP_PLAYERS_ASSIST_TABLE")

data class TopAssistEntity(
    @PrimaryKey
    val id: Int? = 0,
    val playerName: String? = "",
    val teamName: String? = "",
    val totalAssists: Int? = 0
)
