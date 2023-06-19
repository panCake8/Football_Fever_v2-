package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.StatisticPlayersItem

interface PlayersRepository {
    suspend fun getPlayers(fixture: String, team: String): Result<List<StatisticPlayersItem>>
}