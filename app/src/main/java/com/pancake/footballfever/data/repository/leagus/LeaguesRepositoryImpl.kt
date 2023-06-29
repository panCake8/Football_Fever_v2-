package com.pancake.footballfever.data.repository.leagus



import com.pancake.footballfever.data.local.database.daos.LeagueDao
import com.pancake.footballfever.data.local.database.entity.LeagueEntity
import com.pancake.footballfever.data.remote.dto.league.LeaguesDto
import com.pancake.footballfever.data.remote.dto.league.toLeagueEntity
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class LeaguesRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val leagueDao: LeagueDao
) : LeaguesRepository {

    override suspend fun getPremierLeagues(countryName: String): List<LeaguesDto> = apiService.getLeagueByCountryName(countryName).body()?.response!!

    override suspend fun getAllCurrentLeaguesRemote(current: Boolean): List<LeaguesDto> = apiService.getCurrentLeague(current).body()?.response!!


    override suspend fun getAllCurrentLeaguesLocal(): List<LeagueEntity> {
        return leagueDao.getAllLeagues()
    }

    override suspend fun insertAllLeagues(leagues: List<LeagueEntity>) {
        leagueDao.insertLeagues(leagues)
    }

    override suspend fun deleteAllCurrentLeagues() {
        leagueDao.deleteAllLeagues()
    }

    override suspend fun fetchCurrentLeaguesDataAndCache(current: Boolean): Result<List<LeagueEntity>> {
        return try {
            val response = apiService.getCurrentLeague(current)
            if (response.isSuccessful) {
                val data = response.body()?.response?.map { it.toLeagueEntity() }
                data?.let {
                    leagueDao.deleteAllLeagues()
                    leagueDao.insertLeagues(it)
                    Result.success(it)
                }
            }
            Result.failure(Exception(response.message().toString()))
        } catch (e: java.lang.Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getCurrentCachedData(): List<LeagueEntity> {
        return leagueDao.getAllLeagues()
    }

    override suspend fun searchLeaguesByName(name: String): List<LeagueEntity> =
        leagueDao.searchLeaguesByName(name)!!


    // region league state screen
    override suspend fun getLeaguesByIdLocally(leagueId: Int): LeagueEntity = leagueDao.getLeagueById(leagueId)!!

    // endregion
}