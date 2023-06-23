package com.pancake.footballfever.data.repository

import com.pancake.footballfever.data.local.database.entity.FixtureEventsEntity

interface FixtureEventsRepository {
    suspend fun getEventsFixtures(fixtureId: String): Result<List<FixtureEventsEntity>>
}