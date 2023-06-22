package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.FixturesDto
import com.example.footboolfever.data.remote.dto.toFixtureEntity
import com.pancake.footballfever.data.local.database.daos.FixtureDao
import com.pancake.footballfever.data.local.database.entity.FixtureEntity
import com.pancake.footballfever.data.local.database.entity.FixtureHomeEntity
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class FixtureRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val fixtureDao: FixtureDao,
) : FixtureRepository {
    override suspend fun getAllFixturesHomeRemote(
        date: String, teamId: Int, season: Int
    ): List<FixturesDto> {
        return apiService.getFixtureByDateAndTeamIdAndSeason(date, teamId, season)
            .body()?.response!!
    }

    override suspend fun getAllFixturesHomeLocal(): List<FixtureHomeEntity> {
        return fixtureDao.getAllFixtureHome()
    }

    override suspend fun addFixtureHome(teams: List<FixtureHomeEntity>) {
        return fixtureDao.addFixtureHome(teams)
    }

    override suspend fun deleteAllHomeFixtures() {
        fixtureDao.deleteAllFixtureHome()
    }

    override suspend fun fetchFixtureDataAndCache(fixtureId: Int): Result<List<FixtureEntity>> {
        return try {
            val response = apiService.getFixtureById(fixtureId)
            if (response.isSuccessful) {
                val data = response.body()?.response?.map { it.toFixtureEntity() }
                data?.let {
                    fixtureDao.insertFixture(it)
                    return Result.success(it)
                }
            }
            Result.failure(Exception(response.message().toString()))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getFixtureCachedData() = fixtureDao.getFixtures()

}