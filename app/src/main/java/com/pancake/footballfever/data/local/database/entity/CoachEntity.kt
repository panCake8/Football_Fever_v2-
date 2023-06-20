package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "COACHES_TABLE")
data class CoachEntity(
    @PrimaryKey
    val id: Int? = null,
    val name: String? = "",
    val teamName: String? = "",
    val photo: String? = "",
)