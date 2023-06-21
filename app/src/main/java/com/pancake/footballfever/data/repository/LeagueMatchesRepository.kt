package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.FixturesDto
import com.pancake.footballfever.data.local.database.entity.LeagueMatchEntity

interface LeagueMatchesRepository {

    suspend fun getAllLeagueMatches(season: Int, league: Int) : List<FixturesDto>?
    suspend fun addAllLeagueMatches(leagueMatches:List<LeagueMatchEntity>)
    suspend fun getAllLocalLeagueMatches():List<LeagueMatchEntity>

}