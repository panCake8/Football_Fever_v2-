package com.pancake.footballfever.data.repository


import com.example.footboolfever.data.remote.dto.toCoachEntity
import com.pancake.footballfever.data.local.database.daos.FootballDao
import com.pancake.footballfever.data.local.database.entity.CoachEntity
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class ListCoachRepository @Inject constructor(
    private val footballDao: FootballDao,
    private val apiService: ApiService
) : IListCoachRepository {

    override suspend fun fetchCoachAndCache(
    ): Result<List<CoachEntity>> {
        return try {
            val response = apiService.getCoaches()
            if (response.isSuccessful) {
                response.body()?.response?.let { footballDao.insertCoaches(it.map { it.toCoachEntity() }) }
                Result.success(getCachedCoach())
            } else
                Result.failure(Throwable(response.message().toString()))

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getCachedCoach() = footballDao.getAllCoaches()
}