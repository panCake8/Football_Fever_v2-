package com.pancake.footballfever.data.repository.search

import com.example.footboolfever.data.remote.dto.teams.TeamsDto
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class TeamSearchRepositoryImpl  @Inject constructor(
    private val apiService: ApiService): TeamSearchRepository {

    override suspend fun searchTeams(name: String): List<TeamsDto> {
       return apiService.getTeamBySearch(name).body()?.response!!
    }
}