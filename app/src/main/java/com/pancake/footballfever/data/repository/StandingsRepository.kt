package com.pancake.footballfever.data.repository

import com.pancake.footballfever.data.local.database.entity.StandingsEntity
import kotlinx.coroutines.flow.Flow

interface StandingsRepository {
    suspend fun getAllStandings(league:Int,season:Int): List<StandingsEntity>

    suspend fun fetchStandingsAndCache(league:Int,season:Int)
}