package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.local.database.entity.FavoriteTeamEntity
import com.pancake.footballfever.data.repository.TeamRepository
import com.pancake.footballfever.domain.models.ClubModel
import javax.inject.Inject

class AddFavoriteOneTeamUseCase @Inject constructor(
    private val teamRepository: TeamRepository
) {
    suspend fun addFavoriteOneTeam(team: ClubModel) {
        teamRepository.addFavoriteOneTeam(team.toFavoriteEntity())

    }

    private fun ClubModel.toFavoriteEntity(): FavoriteTeamEntity {
        return FavoriteTeamEntity(
            id = 0,
            teamId = this.teamId,
            name = this.teamName,
            logo = this.teamLogo
        )
    }
}