package com.pancake.footballfever.domain.usecases.topScorerUsecase

import com.pancake.footballfever.data.repository.playerRepo.PlayerRepository
import com.pancake.footballfever.domain.models.TopGoals
import com.pancake.footballfever.utilities.toTopGoals
import javax.inject.Inject

class GetTopGoalsCachedDataUseCase @Inject constructor(
    private val playerRepository: PlayerRepository,
) {

    suspend operator fun invoke(): List<TopGoals> {
        return playerRepository.getTopGoalsCachedData().map { it.toTopGoals() }
    }



}