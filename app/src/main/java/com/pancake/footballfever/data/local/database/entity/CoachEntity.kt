package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "COACHES_TABLE")
data class CoachEntity(
    @PrimaryKey
    val id: Int,
    val name: String? = "",
    val team_name: String? = "",
    val photo: String? = "",
)