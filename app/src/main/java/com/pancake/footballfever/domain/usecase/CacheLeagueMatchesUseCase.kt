package com.pancake.footballfever.domain.usecase

import com.example.footboolfever.data.remote.dto.FixturesDto
import com.pancake.footballfever.data.local.database.entity.LeagueMatchEntity
import com.pancake.footballfever.data.repository.LeagueMatchesRepositoryImpl
import com.pancake.footballfever.utilities.toDate
import javax.inject.Inject

class CacheLeagueMatchesUseCase @Inject constructor(
    private val leagueMatchesRepositoryImpl: LeagueMatchesRepositoryImpl,
) {

    suspend fun cacheLeagueMatches(leagueMatches: List<FixturesDto>?, season: Int, league: Int) {
        return leagueMatchesRepositoryImpl.cacheAllLeagueMatches(leagueMatches!!.map {
            it.toLeagueMatchEntity(season, league)
        })
    }

    private fun FixturesDto.toLeagueMatchEntity(season: Int, league: Int): LeagueMatchEntity {
        return LeagueMatchEntity(
            id = fixture?.id!!,
            season = season,
            teamId = league,
            homeTeamLogo = teams?.home?.logo,
            awayTeamLogo = teams?.away?.logo,
            awayTeamName = teams?.away?.name,
            homeTeamName = teams?.home?.name,
            date = fixture?.date?.take(10),
            matchTime = fixture?.timestamp?.toDate(),
        )
    }
}