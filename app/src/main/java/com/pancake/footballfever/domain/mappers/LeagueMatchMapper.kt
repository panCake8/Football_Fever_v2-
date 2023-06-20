package com.pancake.footballfever.domain.mappers

import com.example.footboolfever.data.remote.dto.FixturesDto
import com.pancake.footballfever.domain.models.LeagueMatch

class LeagueMatchMapper:Mapper<FixturesDto,LeagueMatch> {

    override fun map(input: FixturesDto): LeagueMatch {
        return LeagueMatch(
            matchTime = input.fixture?.timestamp,
            homeTeamName = input.teams?.home?.name,
            homeTeamLogo = input.teams?.home?.logo,
            awayTeamName = input.teams?.away?.name,
            awayTeamLogo = input.teams?.away?.logo,
            date = input.fixture?.date
        )
    }
}