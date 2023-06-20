package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.local.database.entity.TopGoalsEntity
import com.pancake.footballfever.data.local.database.repository.PlayerRepository
import com.pancake.footballfever.domain.models.TopGoals
import javax.inject.Inject

class FetchTopGoalsUseCase @Inject constructor(
    private val playerRepository: PlayerRepository,
) {

    suspend operator fun invoke(league: Int, season: Int): Result<List<TopGoals>> {
        return try {
            val result = playerRepository.fetchTopGoalsDataAndCache(league, season)
            val topGoalsList = result.getOrThrow()
                .map { it.toTopGoals() }
            Result.success(topGoalsList)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun TopGoalsEntity.toTopGoals(): TopGoals {
        return TopGoals(
            id = this.id,
            playerName = this.playerName,
            teamName = this.teamName,
            totalGoals = this.totalGoals,
            playerImg = this.playerImg
        )
    }
}