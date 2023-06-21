package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.teams.TeamsDto
import com.pancake.footballfever.data.local.database.daos.ClubDao
import com.pancake.footballfever.data.local.database.entity.ClubEntity
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class ClubRepositoryImpl @Inject constructor(
    private val ApiService: ApiService,
    private val dao: ClubDao
) : ClubRepository {
    override suspend fun getClubById(clubId: Int): Result<TeamsDto> {
        try {
            val response = ApiService.getTeamById(clubId)
            if (response.isSuccessful){
                val data = response.body()
              data?.let {
                  return Result.success(it)
              }
            }
            return Result.failure(Throwable( response.message().toString()))
        }catch (e: Throwable) {
            return Result.failure(e)
        }
    }

    override suspend fun addClubData(clubData: ClubEntity) {
        dao.insertTeam(clubData)
    }

    override suspend fun getLocalClubData(): ClubEntity {
        return dao.getTeam()
    }

}