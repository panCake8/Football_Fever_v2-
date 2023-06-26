package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.repository.TeamRepository
import javax.inject.Inject

class DeleteFromFavouriteTeamsUseCase @Inject constructor(
    private val teamRepository: TeamRepository,
) {
    suspend fun deleteFavouriteTeam(teamId: Int) {
        teamRepository.deleteFavoriteTeam(teamId)
    }
}