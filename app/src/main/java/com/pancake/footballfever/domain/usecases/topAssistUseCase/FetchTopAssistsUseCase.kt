package com.pancake.footballfever.domain.usecases.topAssistUseCase

import com.pancake.footballfever.data.repository.playerRepo.PlayerRepository
import com.pancake.footballfever.domain.models.TopAssists
import com.pancake.footballfever.utilities.toTopAssist
import javax.inject.Inject

class FetchTopAssistsUseCase @Inject constructor(
    private val playerRepository: PlayerRepository,
) {

    suspend operator fun invoke(league: Int, season: Int): Result<List<TopAssists>> {
        return try {
            val result = playerRepository.fetchTopAssistsDataAndCache(league, season)
            val topAssistsList = result.getOrThrow()
                .map {it.toTopAssist()}
            Result.success(topAssistsList)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }


}