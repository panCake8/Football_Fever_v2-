package com.pancake.footballfever.data.repository.playerRepo

import com.example.footboolfever.data.remote.dto.TopAssistsDto
import com.example.footboolfever.data.remote.dto.TopScoresDto
import com.pancake.footballfever.data.local.database.daos.PlayerDao
import com.pancake.footballfever.data.local.database.entity.TopAssistEntity
import com.pancake.footballfever.data.local.database.entity.TopGoalsEntity

import com.pancake.footballfever.data.remote.service.ApiService

import javax.inject.Inject

class PlayerRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val playerDao: PlayerDao,

): PlayerRepository {

    override suspend fun fetchTopGoalsDataAndCache(league: Int, season: Int): Result<List<TopGoalsEntity>> {
        return try {
            val response = apiService.getTopScorerPlayers(league, season)
            if (response.isSuccessful) {
                val data = response.body()?.response?.map { it.toTopGoalsEntity(league, season) }
                data?.let {
                    playerDao.deleteAllTopGoals(league, season)
                    playerDao.insertTopScorer(it)
                    Result.success(it)
                }
            }
            Result.failure(Exception("Failed to retrieve data"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getTopGoalsCachedData(leagueId: Int, seasonId: Int): List<TopGoalsEntity> = playerDao.getAllTopScorers(leagueId, seasonId)

    override suspend fun fetchTopAssistsDataAndCache(
        league: Int,
        season: Int
    ): Result<List<TopAssistEntity>> {
        return try {

            val response = apiService.getTopAssistsPlayers(league, season)
            if (response.isSuccessful) {
                val data = response.body()?.response?.map { it.toTopAssistEntity(league, season) }
                data?.let {
                    playerDao.deleteAllTopAssist(league, season)
                    playerDao.insertTopAssists(it)
                    Result.success(it)
                }
            }
            Result.failure(Exception("Failed to retrieve data"))

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getTopAssistsCachedData(leagueId: Int, seasonId: Int) = playerDao.getAllTopAssists(leagueId, seasonId)

    private fun TopAssistsDto.toTopAssistEntity(LeagueId: Int, season: Int) =
        TopAssistEntity(
            season  = season,
            LeagueId = LeagueId,
            teamId = player?.id!!,
            playerName = player?.name,
            teamName = statistics?.get(0)?.team?.name,
            totalAssists = statistics?.get(0)?.passes?.total,
            playerImg = player?.photo
        )

    private fun TopScoresDto.toTopGoalsEntity(LeagueId: Int, season: Int) =
        TopGoalsEntity(
            teamId = player?.id!!,
            season  = season,
            LeagueId = LeagueId,
            playerName = player?.name,
            teamName = statistics?.get(0)?.team?.name,
            totalGoals = statistics?.get(0)?.goals?.total,
            playerImg = player?.photo

        )

}


