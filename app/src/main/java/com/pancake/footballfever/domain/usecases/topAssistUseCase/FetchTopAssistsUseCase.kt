package com.pancake.footballfever.domain.usecases.topAssistUseCase

import com.pancake.footballfever.data.repository.playerRepo.PlayerRepository
import javax.inject.Inject

class FetchTopAssistsUseCase @Inject constructor(
    private val playerRepository: PlayerRepository,
) {
    suspend operator fun invoke(league: Int, season: Int) = playerRepository.fetchTopAssistsDataAndCache(league, season)

}