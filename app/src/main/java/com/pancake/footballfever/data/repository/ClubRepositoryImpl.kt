package com.pancake.footballfever.data.repository

import androidx.room.Dao
import com.example.footboolfever.data.remote.dto.teams.TeamsDto
import com.pancake.footballfever.data.local.database.entity.TeamEntity
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class ClubRepositoryImpl @Inject constructor(
    private val ApiService: ApiService): ClubRepository
{
    override suspend fun getClubById(clubId: Int): TeamsDto {
        return ApiService.getTeamById(clubId).body()!!
    }

    override suspend fun addClubData(clubData: TeamEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun getLocalClubData(): TeamEntity {
        TODO("Not yet implemented")
    }

}