package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.BaseResponse
import com.example.footboolfever.data.remote.dto.league.LeaguesDto
import retrofit2.Response

interface LeaguesRepository {

    suspend fun getPremierLeagues(countryName : String) : Response<BaseResponse<LeaguesDto>>
}