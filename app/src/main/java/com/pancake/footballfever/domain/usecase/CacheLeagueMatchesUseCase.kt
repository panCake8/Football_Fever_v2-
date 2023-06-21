package com.pancake.footballfever.domain.usecase

import com.example.footboolfever.data.remote.dto.FixturesDto
import com.pancake.footballfever.data.local.mappers.leagueMatchMapper.LeagueMatchesDtoToLocalMapper
import com.pancake.footballfever.data.repository.LeagueMatchesRepositoryImpl
import javax.inject.Inject

class CacheLeagueMatchesUseCase @Inject constructor(
    private val leagueMatchesRepositoryImpl: LeagueMatchesRepositoryImpl,
    private val leagueMatchesDtoToLocalMapper: LeagueMatchesDtoToLocalMapper,
) {

    suspend fun cacheLeagueMatches(leagueMatches: List<FixturesDto>?) {
        return leagueMatchesRepositoryImpl.cacheAllLeagueMatches(leagueMatches!!.map {
            leagueMatchesDtoToLocalMapper.map(
                it
            )
        })
    }
}