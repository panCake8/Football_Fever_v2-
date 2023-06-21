package com.pancake.footballfever.domain.usecases.topAssistUseCase

import com.pancake.footballfever.data.repository.playerRepo.PlayerRepository
import com.pancake.footballfever.domain.models.TopAssists
import com.pancake.footballfever.utilities.toTopAssist
import javax.inject.Inject

class GetTopAssistsCachedDataUseCase  @Inject constructor(
    private val playerRepository: PlayerRepository,
) {
    suspend operator fun invoke(): List<TopAssists> {
        return playerRepository.getTopAssistsCachedData().map { it.toTopAssist() }
    }

}