package com.example.footboolfever.data.local.database.entity

import androidx.room.Entity

@Entity("FIXTURE_EVENT_TABLE")
data class FixtureEvents (
    val time: Int,
    val teamId: Int,
    val playerName: String,
    val type: String
)