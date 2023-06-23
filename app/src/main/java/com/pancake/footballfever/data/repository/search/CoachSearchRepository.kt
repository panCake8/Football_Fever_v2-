package com.pancake.footballfever.data.repository.search

import com.example.footboolfever.data.remote.dto.CoachsDto

interface CoachSearchRepository {

    suspend fun searchCoachs(name:String):List<CoachsDto>
}