package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "VENUE_TABLE")
data class VenueEntity(
    @PrimaryKey
    val id: Int? = 0,
    val country: String? = "",
    val image: String? = "",
    val address: String? = "",
    val city: String? = "",
    val name: String? = "",
    val capacity: Int? = 0,
)
