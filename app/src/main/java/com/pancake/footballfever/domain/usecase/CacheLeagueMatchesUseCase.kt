package com.pancake.footballfever.domain.usecase

import com.example.footboolfever.data.remote.dto.FixturesDto
import com.pancake.footballfever.data.local.database.entity.LeagueMatchEntity
import com.pancake.footballfever.data.repository.LeagueMatchesRepositoryImpl
import com.pancake.footballfever.utilities.toDate
import javax.inject.Inject

class CacheLeagueMatchesUseCase @Inject constructor(
    private val leagueMatchesRepositoryImpl: LeagueMatchesRepositoryImpl,
) {

    suspend fun cacheLeagueMatches(leagueMatches: List<FixturesDto>?) {
        return leagueMatchesRepositoryImpl.cacheAllLeagueMatches(leagueMatches!!.map {
            it.toLeagueMatchEntity()
        })
    }

    private fun FixturesDto.toLeagueMatchEntity(): LeagueMatchEntity {
        return LeagueMatchEntity(
            homeTeamLogo = teams?.home?.logo,
            awayTeamLogo = teams?.away?.logo,
            awayTeamName = teams?.away?.name,
            homeTeamName = teams?.home?.name,
            id = fixture?.id,
            date = fixture?.date?.take(10),
            matchTime = fixture?.timestamp?.toDate(),
        )
    }
}