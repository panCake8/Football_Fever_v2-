package com.pancake.footballfever.domain.usecase

import com.pancake.footballfever.data.repository.PlayerRepository
import com.pancake.footballfever.domain.models.TopGoals
import javax.inject.Inject

class GetTopGoalsCachedDataUseCase @Inject constructor(
    private val playerRepository: PlayerRepository,
) {

    suspend operator fun invoke(): List<TopGoals> {
        return playerRepository.getTopGoalsCachedData().map { it.toTopGoals() }
    }



}