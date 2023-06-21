package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.FixturesDto
import com.pancake.footballfever.data.local.database.daos.LeagueMatchesDao
import com.pancake.footballfever.data.local.database.entity.LeagueMatchEntity
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class LeagueMatchesRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dao: LeagueMatchesDao,
) :
    LeagueMatchesRepository {

    override suspend fun getAllLeagueMatches(
        season: Int,
        league: Int,
    ): List<FixturesDto>? {
        return apiService.getFixturesByLeague(league, season).body()?.response
    }

    override suspend fun addAllLeagueMatches(leagueMatches: List<LeagueMatchEntity>) {
        return dao.addLeagueMatch(leagueMatches)
    }

    override suspend fun getAllLocalLeagueMatches(): List<LeagueMatchEntity> {
        return dao.getAllLeagueMatches()
    }
}