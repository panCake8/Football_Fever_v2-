package com.pancake.footballfever.data.repository

import com.pancake.footballfever.data.local.database.entity.FixtureSummaryEntity

interface FixtureSummaryRepository {
    suspend fun getSummaryFixtures(fixtureId: String): Result<List<FixtureSummaryEntity>>
}