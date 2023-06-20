package com.pancake.footballfever.data.repository

import android.util.Log
import com.example.footboolfever.data.remote.dto.FixturesDto
import com.pancake.footballfever.data.local.database.daos.TeamFixtureDao
import com.pancake.footballfever.data.local.database.entity.FixtureEntity
import com.pancake.footballfever.data.remote.service.ApiService
import java.io.IOException
import javax.inject.Inject

class TeamFixturesRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dao: TeamFixtureDao
) : TeamFixturesRepository {

    override suspend fun getFixtures(season: String, team: String): Result<List<FixtureEntity>> {
        return try {
            dao.insertFixtures(apiService.getTeamFixtures(season, team).body()?.response?.map { it.toEntity() }!!)
            Result.success(dao.getFixtures())
        } catch (e: IOException) {
            with(dao.getFixtures()) {
                if (isNotEmpty()) Result.success(this) else Result.failure(Exception("Please check your internet connection"))
            }
        } catch (e: Exception) {
            Log.e("getFixtures", e.message, e)
            Result.failure(Exception("An unexpected error has occurred"))
        }

    }

    private fun FixturesDto.toEntity() =
        FixtureEntity(
            id = fixture?.id!!,
            timestamp = fixture.timestamp!!,
            homeId = teams?.home?.id!!,
            homeName = teams.home.name!!,
            homeLogo = teams.home.logo!!,
            homeGoals = goals?.home ?: 0,
            homeIsWinner = teams.home.winner ?: false,
            awayId = teams.away?.id!!,
            awayName = teams.away.name!!,
            awayLogo = teams.away.logo!!,
            awayGoals = goals?.away ?: 0,
            awayIsWinner = teams.away.winner ?: false

        )
}