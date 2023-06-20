package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.teams.TeamsDto
import com.pancake.footballfever.data.local.database.daos.ClubDao
import com.pancake.footballfever.data.local.database.entity.TeamEntity
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class ClubRepositoryImpl @Inject constructor(
    private val ApiService: ApiService,
    private val dao: ClubDao
) : ClubRepository {
    override suspend fun getClubById(clubId: Int): TeamsDto {
        return ApiService.getTeamById(clubId).body()!!
    }

    override suspend fun addClubData(clubData: TeamEntity) {
        dao.insertTeam(clubData)
    }

    override suspend fun getLocalClubData(): TeamEntity {
        return dao.getTeam()
    }

}