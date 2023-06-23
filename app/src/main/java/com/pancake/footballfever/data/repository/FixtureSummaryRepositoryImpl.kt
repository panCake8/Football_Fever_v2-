package com.pancake.footballfever.data.repository

import android.util.Log
import com.example.footboolfever.data.remote.dto.EventsDto
import com.pancake.footballfever.data.local.database.daos.FixtureSummaryDao
import com.pancake.footballfever.data.local.database.entity.FixtureSummaryEntity
import com.pancake.footballfever.data.remote.service.ApiService
import java.io.IOException
import javax.inject.Inject

class FixtureSummaryRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dao: FixtureSummaryDao
) : FixtureSummaryRepository {
    override suspend fun getSummaryFixtures(fixtureId: Int): Result<List<FixtureSummaryEntity>> {
        return try {
            dao.insertFixtureSummary(
                apiService.getEventsFixtures(fixtureId).body()?.response?.map {
                    it.toEntity(
                        fixtureId
                    )
                }!!
            )
            Result.success(dao.getFixtureSummary(fixtureId))
        } catch (e: IOException) {
            with(dao.getFixtureSummary(fixtureId)) {
                if (isNotEmpty()) Result.success(this) else Result.failure(Exception("Please check your internet connection"))
            }
        } catch (e: Exception) {
            Log.e("getEventsFixtures", e.message, e)
            Result.failure(Exception("An unexpected error has occurred"))
        }
    }

    private fun EventsDto.toEntity(fixtureId: Int) =
        FixtureSummaryEntity(
            fixtureId = fixtureId,
            time = time?.elapsed!!,
            teamId = team?.id!!,
            playerName = player?.name ?: "",
            type = type ?: "",
            detail = detail ?: ""
        )
}

