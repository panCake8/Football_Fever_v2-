package com.pancake.footballfever.domain.mappers.team

import com.example.footboolfever.data.remote.dto.teams.TeamsDto
import com.pancake.footballfever.domain.mappers.Mapper
import com.pancake.footballfever.domain.models.FavoriteTeam

class FavoriteTeamDtoToUiMapper : Mapper<TeamsDto, FavoriteTeam> {
    override fun map(input: TeamsDto): FavoriteTeam {
        return FavoriteTeam(
            id = input.team?.id!!,
            name = input.team.name!!,
            logo = input.team.logo!!
        )
    }
}