package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.FixturesDto
import com.pancake.footballfever.data.local.database.entity.FixtureEntity
import com.pancake.footballfever.data.local.database.entity.FixtureHomeEntity
import kotlinx.coroutines.flow.Flow

interface FixtureRepository {

    suspend fun getAllFixturesHomeRemote(date: String, teamId: Int, season: Int): List<FixturesDto>

    suspend fun getAllFixturesHomeLocal(): Flow<List<FixtureHomeEntity>>

    suspend fun addFixtureHome(teams:List<FixtureHomeEntity>)

    suspend fun deleteAllHomeFixtures()

    suspend fun fetchFixtureDataAndCache(fixtureId: Int): Result<List<FixtureEntity>>

    suspend fun getFixtureCachedData(): List<FixtureEntity>
}