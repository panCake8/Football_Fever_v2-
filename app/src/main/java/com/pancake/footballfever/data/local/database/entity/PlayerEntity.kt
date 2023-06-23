package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity

@Entity("PLAYER_TABLE", primaryKeys = ["season","teamId", "playerId"])
data class PlayerEntity(
    val season: Int,
    val teamId: Int,
    val playerId: Int,
    val name: String? = "",
    val photo: String? = "",
    val goals: Int? = 0
)
