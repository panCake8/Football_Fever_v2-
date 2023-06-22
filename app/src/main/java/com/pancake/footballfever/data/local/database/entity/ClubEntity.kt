package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pancake.footballfever.domain.models.ClubModel


@Entity(tableName = "TEAM_TABLE")

data class ClubEntity(
    @PrimaryKey
    val teamId: Int?,
    val teamName: String?,
    val teamLogo: String?,
    val teamVenueName: String?,
)

fun ClubModel.toClubEntity(): ClubEntity {
    return ClubEntity(
        teamId = teamId,
        teamName = teamName,
        teamLogo = teamLogo,
        teamVenueName = teamVenueName,
    )
}
fun ClubEntity.toClubModel():ClubModel{
    return ClubModel(
        teamId = teamId,
        teamName = teamName,
        teamLogo = teamLogo,
        teamVenueName = teamVenueName,
    )
}

