package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity

@Entity("FIXTURE_EVENT_TABLE", primaryKeys = ["fixtureId", "time", "teamId", "playerName"])
data class FixtureEventsEntity(
    val fixtureId: String,
    val time: Int,
    val teamId: Int,
    val playerName: String,
    val type: String,
    val detail: String
)