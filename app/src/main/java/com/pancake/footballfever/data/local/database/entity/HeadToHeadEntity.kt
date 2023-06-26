package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "HEAD_TO_HEAD_TABLE")
data class HeadToHeadEntity(
    @PrimaryKey
    val id: Int?,
    val season: Int?,
    val leagueLogo: String?,
    val homeTeamName: String?,
    val homeTeamLogo: String?,
    val homeTeamGoals: String?,
    val awayTeamName: String?,
    val awayTeamLogo: String?,
    val awayTeamGoals: String?,
    val date: String?,
)
