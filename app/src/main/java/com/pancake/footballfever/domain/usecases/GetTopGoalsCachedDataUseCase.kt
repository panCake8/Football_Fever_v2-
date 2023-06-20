package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.local.database.entity.TopGoalsEntity
import com.pancake.footballfever.data.local.database.repository.PlayerRepository
import com.pancake.footballfever.domain.models.TopGoals
import javax.inject.Inject

class GetTopGoalsCachedDataUseCase @Inject constructor(
    private val playerRepository: PlayerRepository,
) {
    suspend operator fun invoke(): List<TopGoals> {
        val result = playerRepository.getTopGoalsCachedData()
        return result.map { it.toTopGoals() }
    }

    private fun TopGoalsEntity.toTopGoals(): TopGoals {
        return TopGoals(
            id = this.id,
            playerName = this.playerName,
            teamName = this.teamName,
            totalGoals = this.totalGoals,
            playerImg = this.playerImg,
        )
    }

}