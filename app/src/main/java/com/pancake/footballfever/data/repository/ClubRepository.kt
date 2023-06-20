package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.teams.TeamsDto
import com.pancake.footballfever.data.local.database.entity.TeamEntity

interface ClubRepository {
    suspend fun getClubById(clubId: Int):TeamsDto
    suspend fun addClubData(clubData:TeamEntity)
    suspend fun getLocalClubData():TeamEntity
}