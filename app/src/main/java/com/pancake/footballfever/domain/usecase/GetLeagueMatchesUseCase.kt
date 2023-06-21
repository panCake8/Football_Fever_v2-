package com.pancake.footballfever.domain.usecase

import com.pancake.footballfever.data.repository.LeagueMatchesRepository
import com.pancake.footballfever.domain.mappers.LeagueMatchMapper
import com.pancake.footballfever.domain.models.LeagueMatch
import javax.inject.Inject

class GetLeagueMatchesUseCase @Inject constructor(
    private val repository: LeagueMatchesRepository,
    private val mapper: LeagueMatchMapper,
) {


    suspend fun getLeagueMatches(season: Int, league: Int): List<LeagueMatch>? {
        return repository.getAllLeagueMatches(season, league)?.map { mapper.map(it) }
    }
}