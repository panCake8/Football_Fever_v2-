package com.pancake.footballfever.data.repository.search

import com.pancake.footballfever.data.remote.dto.league.LeaguesDto
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class LeagueSearchRepositoryImpl@Inject constructor(
    private val apiService: ApiService
): LeagueSearchRepository {

    override suspend fun searchLeagues(name: String): List<LeaguesDto> {
        return apiService.getLeagueBySearch(name).body()?.response!!
    }
}