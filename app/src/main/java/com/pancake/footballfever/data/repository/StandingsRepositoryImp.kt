package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.standings.StandingsDto
import com.pancake.footballfever.data.local.database.daos.FootballDao
import com.pancake.footballfever.data.local.database.entity.StandingsEntity
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject


class StandingsRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val dao: FootballDao
) : StandingsRepository {

    override suspend fun getCachedStandings(leagueId: Int, season: Int): List<StandingsEntity> {
        return dao.getAllStandings(leagueId, season)
    }

    override suspend fun fetchStandingsAndCache(
        leagueId: Int,
        season: Int
    ): Result<List<StandingsEntity>> {
        try {
            val response = apiService.getStandingsLeague(leagueId, season)
            if (response.isSuccessful) {

                val items = response.body()?.response?.mapping
                items?.let {
                    dao.insertStandings(items)
                    return Result.success(items)
                }

            }
            return Result.failure(Throwable( response.message().toString()))
        } catch (e: Exception) {
            return Result.failure(e)

        }


    }

}

private val List<StandingsDto>.mapping: List<StandingsEntity>
    get() {
        val standingsItemItem = this.get(0).league?.standings?.get(0)
        return standingsItemItem?.map {
            StandingsEntity(
                teamId = it?.team?.id!!,
                leagueId = this.get(0).league?.id!!,
                season = this.get(0).league?.season!!,
                rank = it.rank!!,
                teamName = it.team.name!!,
                teamLogoUrl = it.team.logo!!,
                points = it.points!!,
                win = it.all?.win!!,
                played = it.all.played!!,
            )
        }!!
    }