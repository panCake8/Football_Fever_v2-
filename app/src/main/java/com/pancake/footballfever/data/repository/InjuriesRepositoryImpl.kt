package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.toInjuriesEntity
import com.pancake.footballfever.data.local.database.daos.FootballDao
import com.pancake.footballfever.data.local.database.entity.InjuriesEntity
import com.pancake.footballfever.data.remote.service.ApiService
import java.lang.Exception
import javax.inject.Inject

class InjuriesRepositoryImpl @Inject constructor(
    val footballDao: FootballDao,
    val apiService: ApiService,
): InjuriesRepository {

    override suspend fun fetchInjuriesAndCache(
        league: Int,
        season: Int,
    ): Result<List<InjuriesEntity>> {
        return try {
            val response = apiService.getInjuries(league,season)
            if (response.isSuccessful){
                response.body()?.response?.let { footballDao.insertInjuries(it.map { it.toInjuriesEntity() }) }
                Result.success(getCachedInjuries())
            }
            else
                Result.failure(Throwable(response.message().toString()))
        }catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getCachedInjuries() = footballDao.getAllInjuries()
}