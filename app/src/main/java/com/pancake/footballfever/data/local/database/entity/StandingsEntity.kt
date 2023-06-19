package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "STANDINGS_TABLE")
data class StandingsEntity(
    @PrimaryKey
    val teamId: Int,
    val leagueId: Int,
    val season: Int,
    val rank: Int,
    val teamName: String,
    val teamLogoUrl: String,
    val points: Int,
    val win: Int,
    val played: Int,
)