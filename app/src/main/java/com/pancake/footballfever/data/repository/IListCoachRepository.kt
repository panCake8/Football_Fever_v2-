package com.pancake.footballfever.data.repository

import com.pancake.footballfever.data.local.database.entity.CoachEntity

interface IListCoachRepository {

    suspend fun fetchCoachAndCache(): Result<List<CoachEntity>>

    suspend fun getCachedCoach(): List<CoachEntity>
}