package com.pancake.footballfever.data.repository.search

import com.example.footboolfever.data.remote.dto.league.LeaguesDto
import com.example.footboolfever.data.remote.dto.teams.TeamsDto

interface LeagueSearchRepository {

    suspend fun searchLeagues(name:String):List<LeaguesDto>
}