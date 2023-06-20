package com.pancake.footballfever.data.repository


import android.util.Log
import com.example.footboolfever.data.remote.dto.StatisticPlayersItem
import com.pancake.footballfever.data.local.database.daos.PlayersDao
import com.pancake.footballfever.data.local.database.entity.PlayerEntity
import com.pancake.footballfever.data.remote.service.ApiService
import java.io.IOException
import javax.inject.Inject

class PlayersRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dao: PlayersDao
) : PlayersRepository {


    override suspend fun getPlayers(fixture: String, team: String): Result<List<PlayerEntity>> {
        return try {
            dao.insertPlayers(apiService.getTeamPlayerStatisticsFixtures(fixture, team).body()?.response?.get(0)?.players?.map { it?.toEntity()!! }!!)
            Result.success(dao.getPlayers())
        } catch (e: IOException) {
            with(dao.getPlayers()) {
                if (isNotEmpty()) Result.success(this) else Result.failure(Exception("Please check your internet connection"))
            }
        } catch (e: Exception) {
            Log.e("getFixtures", "getFixtures: ${e.message}", e)
            Result.failure(Exception("An unexpected error has occurred"))
        }
    }

    private fun StatisticPlayersItem.toEntity() =
        PlayerEntity(
            id = player?.id,
            name = player?.name,
            photo = player?.photo,
            goals = statistics?.get(0)?.goals?.total ?: 0,
        )

}