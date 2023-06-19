package com.pancake.footballfever.data.local.database.repository

import com.pancake.footballfever.data.local.database.daos.PlayerDao
import com.pancake.footballfever.data.local.database.entity.TopGoalsEntity
import com.pancake.footballfever.data.local.mappers.playerMapper.TopScorerMapper
import com.pancake.footballfever.data.remote.service.ApiService

import javax.inject.Inject

class PlayerRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val playerDao: PlayerDao,
    private val topScorerMapper: TopScorerMapper,
) : PlayerRepository {

    override suspend fun fetchTopGoalsDataAndCache(
        league: Int,
        season: Int
    ): Result<List<TopGoalsEntity>> {
        try {
            val response = apiService.getTopScorerPlayers(league, season)
            if (response.isSuccessful) {

                val data = response.body()?.response
                    ?: return Result.failure(Exception("No data found"))

                playerDao.insertTopScorer(data.map(topScorerMapper::map))

                return Result.success(data.map(topScorerMapper::map))
            }
            return Result.failure(Exception("Failed to retrieve data"))
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun getTopGoalsCachedData(): List<TopGoalsEntity> {
        return playerDao.getAllTopScorers()
    }

}