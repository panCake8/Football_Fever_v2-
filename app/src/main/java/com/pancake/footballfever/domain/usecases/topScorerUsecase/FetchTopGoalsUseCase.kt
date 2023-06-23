package com.pancake.footballfever.domain.usecases.topScorerUsecase

import com.pancake.footballfever.data.repository.playerRepo.PlayerRepository
import javax.inject.Inject

class FetchTopGoalsUseCase @Inject constructor(
    private val playerRepository: PlayerRepository,
) {
    suspend operator fun invoke(league: Int, season: Int) = playerRepository.fetchTopGoalsDataAndCache(league, season)

}