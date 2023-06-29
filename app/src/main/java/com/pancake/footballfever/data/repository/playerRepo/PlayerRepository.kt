package com.pancake.footballfever.data.repository.playerRepo

import com.pancake.footballfever.data.local.database.entity.TopAssistEntity
import com.pancake.footballfever.data.local.database.entity.TopGoalsEntity

interface PlayerRepository {

    // get all scorer data.
    suspend fun fetchTopGoalsDataAndCache(league: Int, season: Int): Result<List<TopGoalsEntity>>
    suspend fun getTopGoalsCachedData(leagueId: Int, seasonId: Int): List<TopGoalsEntity>


    // get all scorer data.
    suspend fun fetchTopAssistsDataAndCache(league: Int, season: Int): Result<List<TopAssistEntity>>
    suspend fun getTopAssistsCachedData(leagueId: Int, seasonId: Int): List<TopAssistEntity>

}