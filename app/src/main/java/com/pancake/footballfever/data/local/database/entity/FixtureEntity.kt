package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "FIXTURE_TABLE")
data class FixtureEntity(
    @PrimaryKey
    val id: Int? = null,
    val date: String? = null,
    val timeStamp: Int? = null,
    val venueName: String? = null,
    val leagueId: Int? = null,
    val country: String? = null,
    val logo: String? = null,
    val leagueName: String? = null,
    val round: String? = null,
    val season: Int? = null,
    val teamHomeId: Int? = null,
    val teamAwayId: Int? = null,
    val teamHomeName: String? = null,
    val teamAwayName: String? = null,
    val teamHomeLogo: String? = null,
    val teamAwayLogo: String? = null,
    val teamHomeGoals: Int? = null,
    val teamAwayGoals: Int? = null,
)