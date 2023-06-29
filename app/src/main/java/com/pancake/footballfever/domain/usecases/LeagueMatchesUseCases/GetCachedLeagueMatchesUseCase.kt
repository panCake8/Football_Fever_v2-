package com.pancake.footballfever.domain.usecases.LeagueMatchesUseCases

import com.pancake.footballfever.data.local.database.daos.LeagueMatchesDao
import com.pancake.footballfever.data.local.database.entity.LeagueMatchEntity
import javax.inject.Inject

class GetCachedLeagueMatchesUseCase @Inject constructor(private val dao: LeagueMatchesDao) {

    suspend fun getCachedLeagueMatches(seasonId: Int, leagueId: Int): List<LeagueMatchEntity> {
        return dao.getAllLeagueMatches(seasonId, leagueId)

    }
}