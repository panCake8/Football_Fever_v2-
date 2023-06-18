package com.example.footboolfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TOP_SCORER")
data class TopScorerEntity(
    @PrimaryKey
    val id: Int? = 0,
    val playerName: String? = "",
    val teamName: String? = "",
    val totalGoals: Int? = 0
)