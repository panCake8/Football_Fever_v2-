package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.FixturesDto
import com.pancake.footballfever.data.local.database.daos.FixtureDao
import com.pancake.footballfever.data.local.database.entity.FixtureHomeEntity
import com.pancake.footballfever.data.remote.service.ApiService
import kotlinx.coroutines.flow.Flow
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

    override suspend fun getAllFixturesHomeLocal(): Flow<List<FixtureHomeEntity>> {
        return fixtureDao.getAllFixtureHome()
    }

    override suspend fun addFixtureHome(teams: List<FixtureHomeEntity>) {
        return fixtureDao.addFixtureHome(teams)
    }

    override suspend fun deleteAllHomeFixtures() {
        fixtureDao.deleteAllFixtureHome()
    }


}