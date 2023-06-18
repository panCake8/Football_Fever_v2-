package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.BaseResponse
import com.example.footboolfever.data.remote.dto.league.LeaguesDto
import com.pancake.footballfever.data.remote.service.ApiService
import retrofit2.Response
import javax.inject.Inject

class LeaguesRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : LeaguesRepository {

    override suspend fun getPremierLeagues(countryName: String): Response<BaseResponse<LeaguesDto>> {
        return apiService.getLeagueByCountryName(countryName)
    }
}