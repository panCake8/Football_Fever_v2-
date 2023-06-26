package com.pancake.footballfever.data.repository.leagus

import com.pancake.footballfever.data.local.database.entity.LeagueEntity
import com.pancake.footballfever.data.remote.dto.league.LeaguesDto

interface LeaguesRepository {
    suspend fun getPremierLeagues(countryName : String) : List<LeaguesDto>

    // region leagues

    suspend fun getAllCurrentLeaguesRemote(current: Boolean): List<LeaguesDto>

    suspend fun getAllCurrentLeaguesLocal(): List<LeagueEntity>

    suspend fun insertAllLeagues(leagues:List<LeagueEntity>)

    suspend fun deleteAllCurrentLeagues()

    suspend fun fetchCurrentLeaguesDataAndCache(current: Boolean): Result<List<LeagueEntity>>

    suspend fun getCurrentCachedData(): List<LeagueEntity>

    suspend fun searchLeaguesByName(name: String): List<LeagueEntity>

    // endregion

    // region leagues state
    suspend fun getLeaguesByIdLocally(leagueId: Int): LeagueEntity

    // endregion
}