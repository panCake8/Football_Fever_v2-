package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.local.database.entity.FixtureHomeEntity
import com.example.footboolfever.data.remote.dto.FixturesDto
import kotlinx.coroutines.flow.Flow

interface FixtureRepository {

    suspend fun getAllFixturesHomeRemote(date: String, teamId: Int, season: Int): List<FixturesDto>
    suspend fun addFixtureHome(teams:List<FixtureHomeEntity>)
    suspend fun getAllFixturesHomeLocal(): Flow<List<FixtureHomeEntity>>
     fun deleteAllFixtureHome()

}