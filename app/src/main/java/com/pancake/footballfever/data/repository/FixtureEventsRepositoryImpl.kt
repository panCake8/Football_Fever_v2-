package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.EventsDto
import com.pancake.footballfever.data.remote.service.ApiService
import java.io.IOException
import javax.inject.Inject

class FixtureEventsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
) : FixtureEventsRepository {
    override suspend fun getEventsFixtures(fixtureId: String): Result<List<EventsDto>> {
        return try {
            Result.success(apiService.getEventsFixtures(fixtureId).body()?.response!!)
        } catch (e: IOException) {
            Result.failure(Exception("Please check your internet connection"))
        } catch (e: Exception) {
            Result.failure(Exception("An unexpected error has occurred"))
        }
    }
}

