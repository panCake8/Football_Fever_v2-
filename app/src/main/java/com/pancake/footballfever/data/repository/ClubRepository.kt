package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.teams.TeamsDto
import com.pancake.footballfever.data.local.database.entity.ClubEntity

interface ClubRepository {
    suspend fun getClubById(clubId: Int):Result<TeamsDto>
    suspend fun addClubData(clubData:ClubEntity)
    suspend fun getLocalClubData():ClubEntity
}