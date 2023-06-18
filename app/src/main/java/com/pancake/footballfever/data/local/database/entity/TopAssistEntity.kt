package com.example.footboolfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TOP_ASSIST")
data class TopAssistEntity(
    @PrimaryKey
    val id: Int? = 0,
    val playerName: String? = "",
    val teamName: String? = "",
    val totalAssists: Int? = 0
)
