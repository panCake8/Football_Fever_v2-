package com.example.footboolfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FIXTURE_TEAM_ENTITY")
data class FixtureHomeEntity(
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val fixture : Int,
    val leagueName : String?,
    val round : String?,
    val elapsed :Int?,
    val timestamp: Long?,
    val homeTeamId : Int,
    val homeTeamName : String,
    val homeTeamLogo : String,
    val homeTeamGoals :Int,
    val awayTeamId : Int,
    val awayTeamName : String,
    val awayTeamLogo : String,
    val awayTeamGoals :Int
)
