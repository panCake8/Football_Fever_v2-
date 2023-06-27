package com.pancake.footballfever.data.repository.game

import com.pancake.footballfever.data.local.database.entity.GameLeagueEntity
import com.pancake.footballfever.data.remote.dto.league.LeaguesDto

interface GameRepository {

    // get the leagues
    suspend fun fetAndCacheGameLeagues() : Result<List<LeaguesDto>>
    suspend fun getCachedGameLeagues() : List<GameLeagueEntity>

    // get the players
    // get the venues
    // get the standings
    // get the what ??

}