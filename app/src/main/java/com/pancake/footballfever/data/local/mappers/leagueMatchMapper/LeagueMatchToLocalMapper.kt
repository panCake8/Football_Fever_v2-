package com.pancake.footballfever.data.local.mappers.leagueMatchMapper

import com.pancake.footballfever.data.local.database.entity.LeagueMatchEntity
import com.pancake.footballfever.domain.mappers.Mapper
import com.pancake.footballfever.domain.models.LeagueMatch

class LeagueMatchToLocalMapper : Mapper<LeagueMatch, LeagueMatchEntity> {
    override fun map(input: LeagueMatch): LeagueMatchEntity {
        return LeagueMatchEntity(
            homeTeamLogo = input.homeTeamLogo,
            awayTeamLogo = input.awayTeamLogo,
            awayTeamName = input.awayTeamName,
            homeTeamName = input.homeTeamName,
            id = input.id,
            date = input.date,
            matchTime = input.matchTime,
        )
    }
}