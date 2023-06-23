package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.teams.TeamsDto
import com.pancake.footballfever.data.local.database.daos.TeamDao
import com.pancake.footballfever.data.local.database.entity.FavoriteTeamEntity
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dao: TeamDao,
) : TeamRepository {

    override suspend fun getPremierLeagueTeams(leagueId: Int, season: Int): List<TeamsDto> {
        return apiService.getPremierLeagueTeams(leagueId, season).body()?.response!!
    }

    override suspend fun addFavoriteTeam(teams: List<FavoriteTeamEntity>) {
        dao.addFavoriteTeam(teams)
    }

    override suspend fun getAllFavoriteTeamsLocal(): List<FavoriteTeamEntity> {
        return dao.getAllFavoriteTeams()
    }

    override suspend fun deleteFavoriteTeam(teamId: Int) {
        dao.deleteFavoriteTeam(teamId)
    }
}