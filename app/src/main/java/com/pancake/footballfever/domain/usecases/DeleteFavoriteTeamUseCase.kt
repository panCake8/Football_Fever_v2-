package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.repository.TeamRepository
import javax.inject.Inject

class DeleteFavoriteTeamUseCase @Inject constructor(
   private val teamRepository: TeamRepository,
) {
    suspend fun deleteTeamFromFavorite(team:Int)= teamRepository
        .deleteFavoriteTeam(team)
}