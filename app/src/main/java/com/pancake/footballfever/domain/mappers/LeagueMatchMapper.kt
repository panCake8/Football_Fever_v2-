package com.pancake.footballfever.domain.mappers

import com.example.footboolfever.data.remote.dto.FixturesDto
import com.pancake.footballfever.domain.models.LeagueMatch
import com.pancake.footballfever.utilities.toDate

class LeagueMatchMapper : Mapper<FixturesDto, LeagueMatch> {

    override fun map(input: FixturesDto): LeagueMatch {
        return LeagueMatch(
            matchTime = input.fixture?.timestamp?.toDate(),
            homeTeamName = input.teams?.home?.name,
            homeTeamLogo = input.teams?.home?.logo,
            awayTeamName = input.teams?.away?.name,
            awayTeamLogo = input.teams?.away?.logo,
            date = input.fixture?.date?.take(10),
            id = input.fixture?.id
        )
    }
}