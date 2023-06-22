package com.pancake.footballfever.data.repository.search

import com.example.footboolfever.data.remote.dto.teams.TeamsDto

interface TeamSearchRepository {

    suspend fun searchTeams(name:String):List<TeamsDto>
}