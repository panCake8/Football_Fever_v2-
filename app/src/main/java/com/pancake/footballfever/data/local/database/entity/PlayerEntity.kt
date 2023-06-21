package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity

@Entity("PLAYER_TABLE", primaryKeys = ["fixtureId","teamId", "playerId"])
data class PlayerEntity(
    val fixtureId: String,
    val teamId: String,
    val playerId: Int,
    val name: String? = "",
    val photo: String? = "",
    val goals: Int? = 0
)
