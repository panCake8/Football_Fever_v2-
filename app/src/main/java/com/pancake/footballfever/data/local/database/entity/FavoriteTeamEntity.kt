package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FAVORITE_TEAM_TABLE")
data class FavoriteTeamEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val teamId: Int?,
    val name: String?,
    val logo: String?
)