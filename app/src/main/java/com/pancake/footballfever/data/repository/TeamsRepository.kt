package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.local.database.entity.FavoriteTeamEntity
import com.example.footboolfever.data.remote.dto.teams.TeamsDto


interface TeamsRepository {

    suspend fun getPremierLeagueTeams(leagueId: Int, season: Int) : List<TeamsDto>
    suspend fun addFavoriteTeam(teams: List<FavoriteTeamEntity>)
    suspend fun getAllFavoriteTeamsLocal() : List<FavoriteTeamEntity>
}