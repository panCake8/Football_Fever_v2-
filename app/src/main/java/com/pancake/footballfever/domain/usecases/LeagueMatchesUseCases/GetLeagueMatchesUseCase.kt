package com.pancake.footballfever.domain.usecases.LeagueMatchesUseCases

import com.example.footboolfever.data.remote.dto.FixturesDto
import com.pancake.footballfever.data.local.database.entity.LeagueMatchEntity
import com.pancake.footballfever.data.repository.LeagueMatchesRepository
import com.pancake.footballfever.domain.models.LeagueMatch
import com.pancake.footballfever.domain.models.LeagueMatchUiModel
import com.pancake.footballfever.domain.models.toLeagueMatchUi
import com.pancake.footballfever.utilities.toDate
import javax.inject.Inject

class GetLeagueMatchesUseCase @Inject constructor(
    private val repository: LeagueMatchesRepository,
    private val cacheLeagueMatchesUseCase: CacheLeagueMatchesUseCase,
    private val getCachedLeagueMatchesUseCase: GetCachedLeagueMatchesUseCase,
) {


    suspend fun getLeagueMatches(season: Int, league: Int): List<LeagueMatchUiModel>? {
        return try {

            val leagueMatches = repository.getAllLeagueMatches(season, league)
            cacheLeagueMatchesUseCase.cacheLeagueMatches(leagueMatches)
            leagueMatches?.map { it.toLeagueMatch() }?.groupBy { it.date }?.toLeagueMatchUi()


        } catch (e: Exception) {
//            throw IOException("error while fetching league matches", e)
//            repository.getAllLocalLeagueMatches().map { it.toLeagueMatch() }.groupBy { it.date }
//                .toLeagueMatchUi()
            getCachedLeagueMatchesUseCase.getCachedLeagueMatches().map { it.toLeagueMatch() }
                .groupBy { it.date }.toLeagueMatchUi()
        }

    }

    private fun LeagueMatchEntity.toLeagueMatch(): LeagueMatch {
        return LeagueMatch(
            date = date,
            homeTeamName = homeTeamName,
            homeTeamLogo = homeTeamLogo,
            awayTeamName = awayTeamName,
            awayTeamLogo = awayTeamLogo,
            matchTime = matchTime,
            id = id,
            season = season,
        )

    }

    private fun FixturesDto.toLeagueMatch(): LeagueMatch {
        return LeagueMatch(
            matchTime = fixture?.timestamp?.toDate(),
            homeTeamName = teams?.home?.name,
            homeTeamLogo = teams?.home?.logo,
            awayTeamName = teams?.away?.name,
            awayTeamLogo = teams?.away?.logo,
            date = fixture?.date?.take(10),
            id = fixture?.id,
            season = league?.season,
        )
    }

}

