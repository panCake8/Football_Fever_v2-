package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.league.LeaguesDto

interface LeaguesRepository {
    suspend fun getPremierLeagues(countryName : String) : List<LeaguesDto>
}