package com.pancake.footballfever.domain.usecase

import com.pancake.footballfever.data.repository.LeagueMatchesRepository
import com.pancake.footballfever.domain.mappers.LeagueMatchMapper
import com.pancake.footballfever.domain.models.LeagueMatch
import javax.inject.Inject

class GetLeagueMatchesUseCase @Inject constructor(
    private val repository: LeagueMatchesRepository,
    private val mapper: LeagueMatchMapper,
    private val cacheLeagueMatchesUseCase: CacheLeagueMatchesUseCase,
) {


    suspend fun getLeagueMatches(season: Int, league: Int): Map<String?, List<LeagueMatch>>? {
        val leagueMatches = repository.getAllLeagueMatches(season, league)
        cacheLeagueMatchesUseCase.cacheLeagueMatches(leagueMatches)
        return leagueMatches?.map { mapper.map(it) }?.groupBy { it.date }

    }
}