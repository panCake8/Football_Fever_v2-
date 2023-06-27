package com.pancake.footballfever.data.repository.game

import android.accounts.NetworkErrorException
import com.pancake.footballfever.data.local.database.daos.GameDao
import com.pancake.footballfever.data.local.database.entity.GameLeagueEntity
import com.pancake.footballfever.data.local.mappers.leagueMapper.toLeaguesGameEntity
import com.pancake.footballfever.data.remote.dto.league.LeaguesDto
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject
class GameRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val gameDao: GameDao,
): GameRepository {

    override suspend fun fetAndCacheGameLeagues(): Result<List<LeaguesDto>> {
        return try {
            val response = apiService.getAllLeagues()
            if (response.isSuccessful) {
                val data = response.body()?.response!!.map { it.toLeaguesGameEntity() }
                cacheGameLeagues(data)
                Result.success(data)
            }
            Result.failure(Exception(response.message().toString()))
        } catch (e: NetworkErrorException) {
            Result.failure(e)
        }

    }

    private suspend fun cacheGameLeagues(data: List<GameLeagueEntity>) {
        val x = data
        data.let {
            gameDao.deleteAllLeagues()
            gameDao.insertGameLeagues(it)
        }
    }

    override suspend fun getCachedGameLeagues(): List<GameLeagueEntity> = gameDao.getAllLeagues()

}

