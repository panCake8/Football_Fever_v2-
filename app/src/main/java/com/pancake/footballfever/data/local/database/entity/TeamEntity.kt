package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "TEAM_TABLE")

data class TeamEntity(
    @PrimaryKey
    val teamId: Int,
    val teamName: String,
    val teamLogo: String,
    val teamVenueName: String,
)


