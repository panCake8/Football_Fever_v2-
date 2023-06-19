package com.pancake.footballfever.data.repository

import com.pancake.footballfever.data.local.database.daos.FootballDao
import com.pancake.footballfever.data.local.database.entity.StandingsEntity
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class StandingsRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val dao: FootballDao,
) : StandingsRepository {

    override suspend fun getAllStandings(league: Int, season: Int): List<StandingsEntity> {
        return dao.getAllStandings(league, season)
    }

    override suspend fun fetchStandingsAndCache(league: Int, season: Int) {
        val response = apiService.getStandingsLeague(league, season)
        val items = response.body()
            ?.response
            ?.get(FIRST_ITEM)
    }

//    override suspend fun getStandingsLeagueLocal(league: Int, season: Int): List<StandingsEntity> {
//        if (dao.getAllStandings().isEmpty()) {
//            val response = getStandingsLeagueRemote(league, season)[FIRST_ITEM]
//                .league
//                ?.standings
//                ?.get(FIRST_ITEM)!!
//                .map(standingsMapper::map)
//
//            dao.insertStandings(response)
//
//        }
//        return dao.getAllStandings()
//    }

    companion object {
        const val FIRST_ITEM = 0
    }


}