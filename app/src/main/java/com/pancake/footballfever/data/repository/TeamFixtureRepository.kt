package com.pancake.footballfever.data.repository

import com.pancake.footballfever.data.local.database.entity.FixtureEntity

interface TeamFixturesRepository {
    suspend fun getFixtures(season: String, team: String): Result<List<FixtureEntity>>

}