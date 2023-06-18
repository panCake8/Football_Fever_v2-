package com.pancake.footballfever.data.local.mappers.leagueMapper

import com.example.footboolfever.data.local.database.entity.LeagueEntity
import com.example.footboolfever.data.remote.dto.league.LeaguesDto
import com.pancake.footballfever.data.local.mappers.IMapper

class LeagueMapper : IMapper<LeaguesDto, LeagueEntity> {
    override fun map(input: LeaguesDto): LeagueEntity {
        return LeagueEntity(
            id = input.league?.id,
            name = input.league?.name,
            logo = input.league?.logo,
            type = input.league?.type,
        )
    }
}