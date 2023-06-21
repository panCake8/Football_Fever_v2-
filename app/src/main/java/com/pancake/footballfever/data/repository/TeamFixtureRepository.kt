package com.pancake.footballfever.data.repository

import com.pancake.footballfever.data.local.database.entity.TeamFixtureEntity

interface TeamFixturesRepository {
    suspend fun getFixtures(season: String, team: String): Result<List<TeamFixtureEntity>>

}