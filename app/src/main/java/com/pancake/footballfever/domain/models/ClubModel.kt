package com.pancake.footballfever.domain.models

import com.example.footboolfever.data.remote.dto.teams.TeamsDto

data class ClubModel(
    val teamId: Int?,
    val teamName: String?,
    val teamLogo: String?,
    val teamVenueName: String?,
)
fun TeamsDto.toClubModel(): ClubModel {
    return ClubModel(
        teamId=team?.id,
        teamName=team?.name,
        teamLogo=team?.logo,
        teamVenueName=venue?.name,
    )
}