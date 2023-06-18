package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("FIXTURE_EVENT_TABLE")
data class FixtureEventsEntity(
    @PrimaryKey
    val id: Int,
    val time: Int,
    val teamId: Int,
    val playerName: String,
    val type: String,
)