package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pancake.footballfever.domain.models.Coaches

@Entity(tableName = "COACHES_TABLE")
data class CoachEntity(
    @PrimaryKey
    val id: Int? = null,
    val name: String? = "",
    val teamName: String? = "",
    val photo: String? = "",
)

fun CoachEntity.toCoachModel(): Coaches {
    return Coaches(
        name = name,
        teamName = teamName,
        photo = photo,
    )
}