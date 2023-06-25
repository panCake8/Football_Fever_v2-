package com.pancake.footballfever.data.repository.search

import com.pancake.footballfever.data.remote.dto.league.LeaguesDto

interface LeagueSearchRepository {

    suspend fun searchLeagues(name:String):List<LeaguesDto>
}