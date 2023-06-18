package com.pancake.footballfever.data.local.mappers.fixtureMapper

import com.pancake.footballfever.data.local.database.entity.FixtureHomeEntity
import com.example.footboolfever.data.remote.dto.FixturesDto
import com.pancake.footballfever.data.local.mappers.Mapper
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class FixturesHomeDtoToEntityMapper @Inject constructor() : Mapper<FixturesDto, FixtureHomeEntity> {
    override fun map(input: FixturesDto): FixtureHomeEntity {
        return FixtureHomeEntity(
            id = 0,
            fixture = input.fixture?.id!!,
            leagueName = input.league?.name,
            round = input.league?.round,
            elapsed = input.fixture.status?.elapsed,
            timestamp = input.fixture.timestamp?.toLong(),
            homeTeamId = input.teams?.home?.id!!,
            homeTeamName = input.teams.home.name!!,
            homeTeamLogo = input.teams.home.logo!!,
            homeTeamGoals = input.goals?.home!!,
            awayTeamId = input.teams.away?.id!!,
            awayTeamName = input.teams.away.name!!,
            awayTeamLogo = input.teams.away.logo!!,
            awayTeamGoals = input.goals.away!!
        )
    }
}