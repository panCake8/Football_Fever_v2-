package com.pancake.footballfever.data.local.mappers.leagueMapper

import com.pancake.footballfever.data.local.database.entity.LeagueEntity
import com.pancake.footballfever.data.local.mappers.Mapper
import com.pancake.footballfever.data.remote.dto.league.LeaguesDto
import javax.inject.Inject

class LeagueMapper @Inject constructor() : Mapper<LeaguesDto, LeagueEntity> {
    override fun map(input: LeaguesDto): LeagueEntity {
        return LeagueEntity(
            id = input.league?.id,
            name = input.league?.name,
            logo = input.league?.logo,
            country = input.country?.name,
            year = input.seasons?.get(0)?.year,
            type = input.league?.type,
        )
    }
}