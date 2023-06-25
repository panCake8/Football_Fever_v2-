package com.pancake.footballfever.domain.usecase

import com.pancake.footballfever.data.local.database.daos.LeagueMatchesDao
import com.pancake.footballfever.data.local.database.entity.LeagueMatchEntity
import javax.inject.Inject

class GetCachedLeagueMatchesUseCase @Inject constructor(private val dao: LeagueMatchesDao) {

    suspend fun getCachedLeagueMatches(): List<LeagueMatchEntity> {
        return dao.getAllLeagueMatches()

    }
}