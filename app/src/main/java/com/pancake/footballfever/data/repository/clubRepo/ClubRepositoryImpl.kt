package com.pancake.footballfever.data.repository.clubRepo

import com.example.footboolfever.data.remote.dto.teams.TeamsDto
import com.pancake.footballfever.data.local.database.daos.ClubDao
import com.pancake.footballfever.data.local.database.entity.ClubEntity
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class ClubRepositoryImpl @Inject constructor(
    private val ApiService: ApiService,
    private val dao: ClubDao
) : ClubRepository {
    override suspend fun getClubById(clubId: Int): TeamsDto {
        return ApiService.getTeamById(clubId).body()?.response?.get(0)!!
    }

    override suspend fun addClubData(clubData: ClubEntity) {
        dao.insertTeam(clubData)
    }

    override suspend fun deleteClubData() {
        dao.deleteTeam()
    }

    override suspend fun getLocalClubData(): ClubEntity {
        return dao.getTeam()
    }


}