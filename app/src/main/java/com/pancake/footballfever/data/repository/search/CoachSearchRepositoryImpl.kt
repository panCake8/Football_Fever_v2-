package com.pancake.footballfever.data.repository.search

import com.example.footboolfever.data.remote.dto.CoachsDto
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class CoachSearchRepositoryImpl@Inject constructor(
    private val apiService: ApiService
): CoachSearchRepository {

    override suspend fun searchCoachs(name: String): List<CoachsDto> {
        return apiService.getCoachBySearch(name).body()?.response!!
    }
}