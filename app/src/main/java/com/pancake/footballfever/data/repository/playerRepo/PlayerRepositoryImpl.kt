package com.pancake.footballfever.data.repository.playerRepo

import com.pancake.footballfever.data.local.database.daos.PlayerDao
import com.pancake.footballfever.data.local.database.entity.TopAssistEntity
import com.pancake.footballfever.data.local.database.entity.TopGoalsEntity
import com.pancake.footballfever.data.local.mappers.playerMapper.TopAssistsMapper
import com.pancake.footballfever.data.local.mappers.playerMapper.TopScorerMapper
import com.pancake.footballfever.data.remote.service.ApiService

import javax.inject.Inject

class PlayerRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val playerDao: PlayerDao,
    private val topScorerMapper: TopScorerMapper,
    private val topAssistsMapper: TopAssistsMapper,
): PlayerRepository {

    override suspend fun fetchTopGoalsDataAndCache(league: Int, season: Int): Result<List<TopGoalsEntity>> {
        try {

            val response = apiService.getTopScorerPlayers(league, season)
            if (response.isSuccessful) {
                val data = response.body()?.response
                data?.let {
                    playerDao.insertTopScorer(it.map(topScorerMapper::map))
                    return Result.success(it.map(topScorerMapper::map))
                }
            }
            return Result.failure(Exception("Failed to retrieve data"))

        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun getTopGoalsCachedData() = playerDao.getAllTopScorers()



    override suspend fun fetchTopAssistsDataAndCache(
        league: Int,
        season: Int
    ): Result<List<TopAssistEntity>> {
        try {

            val response = apiService.getTopAssistsPlayers(league, season)
            if (response.isSuccessful) {
                val data = response.body()?.response
                data?.let {
                    playerDao.insertTopAssists(it.map(topAssistsMapper::map))
                    return Result.success(it.map(topAssistsMapper::map))
                }
            }
            return Result.failure(Exception("Failed to retrieve data"))

        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun getTopAssistsCachedData() = playerDao.getAllTopAssists()


}


