package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity

@Entity("FIXTURE_SUMMARY_TABLE", primaryKeys = ["fixtureId", "time", "teamId", "playerName"])
data class FixtureSummaryEntity(
    val fixtureId: Int,
    val time: Int,
    val teamId: Int,
    val playerName: String,
    val type: String,
    val detail: String
)