package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.FixturesDto

interface TeamFixturesRepository {
    suspend fun getFixtures(season: String, team: String): Result<List<FixturesDto>>

}