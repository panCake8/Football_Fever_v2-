package com.pancake.footballfever.data.repository


import com.example.footboolfever.data.remote.dto.league.LeaguesDto
import com.pancake.footballfever.data.local.database.daos.LeagueDao
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class LeaguesRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dao: LeagueDao
) : LeaguesRepository {

    override suspend fun getPremierLeagues(countryName: String): List<LeaguesDto> {
        return apiService.getLeagueByCountryName(countryName).body()?.response!!
    }

}