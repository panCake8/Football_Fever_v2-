package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.FixturesDto
import com.pancake.footballfever.data.remote.service.ApiService
import java.io.IOException
import javax.inject.Inject

class TeamFixturesRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
) : TeamFixturesRepository {

    override suspend fun getFixtures(season: String, team: String): Result<List<FixturesDto>> {
        return try {
            Result.success(apiService.getTeamFixtures(season, team).body()?.response!!)
        } catch (e: IOException) {
            Result.failure(Exception("Please check your internet connection"))

        } catch (e: Exception) {
            Result.failure(Exception("An unexpected error has occurred"))
        }
    }

}