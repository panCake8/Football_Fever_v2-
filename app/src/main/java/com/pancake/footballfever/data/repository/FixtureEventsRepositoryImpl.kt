package com.pancake.footballfever.data.repository

import android.util.Log
import com.example.footboolfever.data.remote.dto.EventsDto
import com.pancake.footballfever.data.local.database.daos.FixtureEventsDao
import com.pancake.footballfever.data.local.database.entity.FixtureEventsEntity
import com.pancake.footballfever.data.remote.service.ApiService
import java.io.IOException
import javax.inject.Inject

class FixtureEventsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dao: FixtureEventsDao
) : FixtureEventsRepository {
    override suspend fun getEventsFixtures(fixtureId: String): Result<List<FixtureEventsEntity>> {
        return try {
            dao.insertFixtureEvents(apiService.getEventsFixtures(fixtureId).body()?.response?.map { it.toEntity(fixtureId) }!!)
            Result.success(dao.getFixtureEvents(fixtureId))
        } catch (e: IOException) {
            with(dao.getFixtureEvents(fixtureId)) {
                if (isNotEmpty()) Result.success(this) else Result.failure(Exception("Please check your internet connection"))
            }
        } catch (e: Exception) {
            Log.e("getEventsFixtures", e.message, e)
            Result.failure(Exception("An unexpected error has occurred"))
        }
    }

    private fun EventsDto.toEntity(fixtureId: String) =
        FixtureEventsEntity(
            fixtureId = fixtureId,
            time = time?.elapsed!!,
            teamId = team?.id!!,
            playerName = player?.name ?: "",
            type = type ?: "",
            detail = detail ?: ""
        )
}

