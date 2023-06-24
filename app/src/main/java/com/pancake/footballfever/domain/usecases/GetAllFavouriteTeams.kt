package com.pancake.footballfever.domain.usecases


import com.pancake.footballfever.data.local.database.entity.FavoriteTeamEntity
import com.pancake.footballfever.data.repository.TeamRepository
import com.pancake.footballfever.domain.models.FavoriteTeam
import javax.inject.Inject

class GetAllFavouriteTeams @Inject constructor(
    private val favouriteRepository: TeamRepository,
) {
    suspend fun getAllTeams(): List<FavoriteTeam> {
        return favouriteRepository.getAllFavoriteTeamsLocal().map { it.toFavouriteTeam() }
    }

    private fun FavoriteTeamEntity.toFavouriteTeam(): FavoriteTeam {
        return FavoriteTeam(
            id = this.teamId,
            name = this.name,
            logo = this.logo
        )
    }
}