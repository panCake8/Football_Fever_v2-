package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.repository.LeaguesRepository
import com.pancake.footballfever.data.repository.TeamRepository
import com.pancake.footballfever.domain.mappers.team.FavoriteTeamDtoToUiMapper
import com.pancake.footballfever.domain.models.FavoriteTeam
import javax.inject.Inject

class GetPremierLeagueTeamsUseCase @Inject constructor(
    private val teamRepository: TeamRepository,
    private val leaguesRepository: LeaguesRepository,
    private val teamsMapper: FavoriteTeamDtoToUiMapper
) {

    suspend fun getPremierLeagueTeams(
        countryName: String,
        season: Int
    ): List<FavoriteTeam> {
        val leagues = leaguesRepository.getPremierLeagues(countryName)
        val premierLeagueId = leagues[FIRST_LEAGUE].league?.id!!
        return teamRepository.getPremierLeagueTeams(premierLeagueId, season).map(teamsMapper::map)
    }

    companion object {
        const val FIRST_LEAGUE = 0
    }
}