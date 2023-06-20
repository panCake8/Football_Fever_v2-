package com.pancake.footballfever.data.repository.fixtureRepo

import com.pancake.footballfever.data.local.database.entity.FixtureEntity

interface IFixtureRepository {
    suspend fun fetchFixtureDataAndCache(fixtureId: Int): Result<List<FixtureEntity>>

    suspend fun getFixtureCachedData(): List<FixtureEntity>

}