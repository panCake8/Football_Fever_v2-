package com.pancake.footballfever.data.repository.PlayerRepo

import com.example.footboolfever.data.remote.dto.TopScoresDto
import com.pancake.footballfever.data.local.database.entity.TopGoalsEntity

interface PlayerRepository {

    // get all scorer data.
    suspend fun fetchTopGoalsDataAndCache(league: Int, season: Int): Result<List<TopGoalsEntity>>
    suspend fun getTopGoalsCachedData(): List<TopGoalsEntity>

    suspend fun getAllRemoteTopScorer( league: Int, season: Int,): List<TopScoresDto>?

    suspend fun saveData(data: List<TopGoalsEntity>)


}