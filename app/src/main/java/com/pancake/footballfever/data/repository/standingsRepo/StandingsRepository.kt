package com.pancake.footballfever.data.repository.standingsRepo

import com.pancake.footballfever.data.local.database.entity.StandingsEntity

interface StandingsRepository {
    suspend fun getCachedStandings(leagueId: Int, season: Int): List<StandingsEntity>

    suspend fun fetchStandingsAndCache(leagueId: Int, season: Int): Result<List<StandingsEntity>>
}