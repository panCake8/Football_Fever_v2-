package com.pancake.footballfever.data.repository

import com.pancake.footballfever.data.local.database.entity.PlayerEntity

interface PlayersRepository {
    suspend fun getPlayers(season: Int, team: Int): Result<List<PlayerEntity>>
}