package com.pancake.footballfever.data.repository


import com.example.footboolfever.data.remote.dto.StatisticPlayersItem
import com.pancake.footballfever.data.remote.service.ApiService
import java.io.IOException
import javax.inject.Inject

class PlayersRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
) : PlayersRepository {


    override suspend fun getPlayers(fixture: String, team: String): Result<List<StatisticPlayersItem>> {
        return try {
            Result.success(apiService.getTeamPlayerStatisticsFixtures(fixture, team).body()?.response?.get(0)?.players?.map { it!! }!!)
        } catch (e: IOException) {
            Result.failure(Exception("Please check your internet connection"))
        } catch (e: Exception) {
            Result.failure(Exception("An unexpected error has occurred"))
        }
    }


}