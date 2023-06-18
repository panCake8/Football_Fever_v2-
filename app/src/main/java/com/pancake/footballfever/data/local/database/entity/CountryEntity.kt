package com.example.footboolfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "COUNTRY_TABLE")
data class CountryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String? = "",
    val flag: String? = "",
)