package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("TEAM_FIXTURE_TABLE")
data class TeamFixtureEntity(
    @PrimaryKey val fixtureId: Int,
    val timestamp: Int,

    val season: String,
    val team: String,
    val homeId: Int,
    val homeName: String,
    val homeLogo: String,
    val homeGoals: Int,
    val homeIsWinner: Boolean,

    val awayId: Int,
    val awayName: String,
    val awayLogo: String,
    val awayGoals: Int,
    val awayIsWinner: Boolean,
)
