package com.pancake.footballfever.data.repository


import android.util.Log
import com.example.footboolfever.data.remote.dto.PlayersDto
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


    override suspend fun getPlayers(season: Int, team: Int): Result<List<PlayerEntity>> {
        return try {
            dao.insertPlayers(
                apiService.getTeamPlayerStatisticsFixtures(season, team).body()?.response?.map { it?.toEntity(season, team)!! }!!
            )
            Result.success(dao.getPlayers(season, team))
        } catch (e: IOException) {
            with(dao.getPlayers(season, team)) {
                if (isNotEmpty()) Result.success(this) else Result.failure(Exception("Please check your internet connection"))
            }
        } catch (e: Exception) {
            Log.e("getPlayers", e.message, e)
            Result.failure(Exception("An unexpected error has occurred"))
        }
    }

    private fun PlayersDto.toEntity(season: Int, teamId: Int) =
        PlayerEntity(
            season = season,
            teamId = teamId,
            playerId = player?.id!!,
            name = player.name,
            photo = player.photo,
            goals = statistics?.get(0)?.goals?.total ?: 0,
        )



}