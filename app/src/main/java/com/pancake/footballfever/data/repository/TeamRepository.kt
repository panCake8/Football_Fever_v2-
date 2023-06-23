package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.teams.TeamsDto
import com.pancake.footballfever.data.local.database.entity.FavoriteTeamEntity

interface TeamRepository {

    suspend fun getPremierLeagueTeams(leagueId: Int, season: Int) : List<TeamsDto>

    suspend fun addFavoriteTeam(teams: List<FavoriteTeamEntity>)

    suspend fun getAllFavoriteTeamsLocal() : List<FavoriteTeamEntity>
    suspend fun deleteFavoriteTeam(teamId: Int)
    suspend fun addFavoriteOneTeam(team: FavoriteTeamEntity)
}