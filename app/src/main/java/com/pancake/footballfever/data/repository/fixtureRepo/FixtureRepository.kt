package com.pancake.footballfever.data.repository.fixtureRepo

import com.example.footboolfever.data.remote.dto.toFixtureEntity
import com.pancake.footballfever.data.local.database.daos.FixtureDao
import com.pancake.footballfever.data.local.database.entity.FixtureEntity
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class FixtureRepository @Inject constructor(
    private val apiService: ApiService,
    private val dao: FixtureDao,
) : IFixtureRepository {
    override suspend fun fetchFixtureDataAndCache(fixtureId: Int): Result<List<FixtureEntity>> {
        return try {
            val response = apiService.getFixtureById(fixtureId)
            if (response.isSuccessful) {
                val data = response.body()?.response?.map { it.toFixtureEntity() }
                data?.let {
                    dao.insertFixture(it)
                    Result.success(it)
                }
            }
            Result.failure(Exception(response.message().toString()))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getFixtureCachedData() = dao.getFixtures()
}