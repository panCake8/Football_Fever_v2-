package com.pancake.footballfever.data.repository

import com.pancake.footballfever.data.local.database.daos.FootballDao
import com.pancake.footballfever.data.local.database.entity.StandingsEntity
import com.pancake.footballfever.data.local.mappers.StandingsMapper
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class StandingsRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val dao: FootballDao,
    private val mapper:StandingsMapper
) : StandingsRepository {


    override suspend fun getAllStandings(league: Int, season: Int): List<StandingsEntity> {
        return dao.getAllStandings(league, season)
    }

    override suspend fun fetchStandingsAndCache(league: Int, season: Int) {
        val response = apiService.getStandingsLeague(league, season)
        val items = response.body()?.response?.let { mapper.map(it.get(0)) }
        items?.let { dao.insertStandings(items) }
    }

}