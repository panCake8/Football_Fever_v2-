package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("PLAYER_TABLE")
data class PlayerEntity(
    @PrimaryKey val id: Int? = -1,
    val name: String? = "",
    val photo: String? = "",
    val goals: Int? = 0
)
