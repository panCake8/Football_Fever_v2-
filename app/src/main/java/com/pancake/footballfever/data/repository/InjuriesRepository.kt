package com.pancake.footballfever.data.repository

import com.pancake.footballfever.data.local.database.entity.InjuriesEntity

interface InjuriesRepository {

    suspend fun fetchInjuriesAndCache(): Result<List<InjuriesEntity>>

    suspend fun getCachedInjuries(): List<InjuriesEntity>
}