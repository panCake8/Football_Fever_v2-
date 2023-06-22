package com.pancake.footballfever.domain.usecase

import android.util.Log
import com.pancake.footballfever.data.repository.LeagueMatchesRepository
import com.pancake.footballfever.domain.mappers.LeagueMatchMapper
import com.pancake.footballfever.domain.models.LeagueMatch
import com.pancake.footballfever.domain.models.LeagueMatchUiModel
import com.pancake.footballfever.domain.models.toLeagueMatchUi
import java.io.IOException
import javax.inject.Inject

class GetLeagueMatchesUseCase @Inject constructor(
    private val repository: LeagueMatchesRepository,
    private val mapper: LeagueMatchMapper,
    private val cacheLeagueMatchesUseCase: CacheLeagueMatchesUseCase,
) {


    suspend fun getLeagueMatches(season: Int, league: Int): List<LeagueMatchUiModel>? {
        return try {

            val leagueMatches = repository.getAllLeagueMatches(season, league)
            cacheLeagueMatchesUseCase.cacheLeagueMatches(leagueMatches)
            leagueMatches?.map { mapper.map(it) }?.groupBy { it.date }?.toLeagueMatchUi()


        } catch (e: Exception) {
            throw IOException("error while fetching league matches", e)
        }

    }
}