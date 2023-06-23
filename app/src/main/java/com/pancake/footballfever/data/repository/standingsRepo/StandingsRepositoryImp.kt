package com.pancake.footballfever.data.repository.standingsRepo

import com.pancake.footballfever.data.local.database.daos.FootballDao
import com.pancake.footballfever.data.local.database.entity.StandingsEntity
import com.pancake.footballfever.data.remote.service.ApiService
import com.pancake.footballfever.utilities.toStandingsEntity
import javax.inject.Inject

class StandingsRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val dao: FootballDao,
) : StandingsRepository {


    override suspend fun getCachedStandings(leagueId: Int, season: Int): List<StandingsEntity> {
        return dao.getAllStandings(leagueId, season)
    }

    override suspend fun fetchStandingsAndCache(
        leagueId: Int,
        season: Int
    ): Result<List<StandingsEntity>> {
        try {
            val response = apiService.getStandingsLeague(leagueId, season)
            if (response.isSuccessful) {

                val items = response.body()?.response?.first()?.let {  it.toStandingsEntity() }
                items?.let {
                    dao.insertStandings(items)
                    return Result.success(items)
                }

            }
            return Result.failure(Throwable( response.message().toString()))
        } catch (e: Exception) {
            return Result.failure(e)

        }


    }

}