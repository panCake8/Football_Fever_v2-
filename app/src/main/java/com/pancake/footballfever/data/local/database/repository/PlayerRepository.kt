package com.pancake.footballfever.data.local.database.repository

import com.pancake.footballfever.data.local.database.entity.TopGoalsEntity

interface PlayerRepository {

    // get all scorer data.
    suspend fun fetchTopGoalsDataAndCache(league: Int, season: Int): Result<List<TopGoalsEntity>>
    suspend fun getTopGoalsCachedData(): List<TopGoalsEntity>


}
