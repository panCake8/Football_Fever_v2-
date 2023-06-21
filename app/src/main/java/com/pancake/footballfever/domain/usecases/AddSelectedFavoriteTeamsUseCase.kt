package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.local.mappers.teamMapper.FavoriteTeamUiToEntityMapper
import com.pancake.footballfever.data.repository.TeamRepository
import com.pancake.footballfever.domain.models.FavoriteTeam
import javax.inject.Inject

class AddSelectedFavoriteTeamsUseCase @Inject constructor(
    private val teamRepository: TeamRepository,
    private val favoriteTeamUiToEntityMapper: FavoriteTeamUiToEntityMapper
) {

    suspend fun addFavoriteTeams(teams: List<FavoriteTeam>) {
        teamRepository.addFavoriteTeam(teams.map(favoriteTeamUiToEntityMapper::map))
    }
}