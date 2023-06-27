package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.FixturesDto
import com.example.footboolfever.data.remote.dto.StatisticsDto
import com.pancake.footballfever.data.local.database.entity.FixtureEntity
import com.pancake.footballfever.data.local.database.entity.FixtureHomeEntity
import com.pancake.footballfever.domain.models.FixtureStatistics
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

interface FixtureRepository {

    suspend fun getAllFixturesHomeRemote(date: String, teamId: Int, season: Int): List<FixturesDto>

    suspend fun getAllFixturesHomeLocal(): Flow<List<FixtureHomeEntity>>

    suspend fun addFixtureHome(teams: List<FixtureHomeEntity>)

    suspend fun deleteAllHomeFixtures()

    suspend fun fetchFixtureDataAndCache(fixtureId: Int): Result<List<FixtureEntity>>

    suspend fun getFixtureCachedData(): List<FixtureEntity>

    suspend fun getFixtureStatistics(fixtureId: Int): Result<FixtureStatistics?>
}