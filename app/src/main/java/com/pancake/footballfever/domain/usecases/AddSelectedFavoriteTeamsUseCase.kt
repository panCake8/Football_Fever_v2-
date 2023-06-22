package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.local.database.entity.FavoriteTeamEntity
import com.pancake.footballfever.data.repository.TeamRepository
import com.pancake.footballfever.domain.models.FavoriteTeam
import javax.inject.Inject

class AddSelectedFavoriteTeamsUseCase @Inject constructor(
    private val teamRepository: TeamRepository,
) {

    suspend fun addFavoriteTeams(teams: List<FavoriteTeam>) {
        teamRepository.addFavoriteTeam(teams.map{it.toFavoriteTeamEntity()})
    }

    private fun FavoriteTeam.toFavoriteTeamEntity(): FavoriteTeamEntity {
        return FavoriteTeamEntity(
            id = 0,
            teamId = this.id,
            name = this.name,
            logo = this.logo
        )
    }
}