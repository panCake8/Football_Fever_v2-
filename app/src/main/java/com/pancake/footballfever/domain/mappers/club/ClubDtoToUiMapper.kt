package com.pancake.footballfever.domain.mappers.club

import com.example.footboolfever.data.remote.dto.teams.TeamsDto
import com.pancake.footballfever.domain.mappers.Mapper
import com.pancake.footballfever.domain.models.ClubModel

class ClubDtoToUiMapper:Mapper<TeamsDto,ClubModel> {
    override fun map(input: TeamsDto): ClubModel {
        return ClubModel(
            teamId=input.team?.id!!,
            teamName=input.team.name!!,
            teamLogo=input.team.logo!!,
            teamVenueName=input.venue?.name!!,
        )
    }
}