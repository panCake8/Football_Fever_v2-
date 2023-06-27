package com.pancake.footballfever.domain.usecases.gameUseCase

import com.pancake.footballfever.data.repository.game.GameRepository
import javax.inject.Inject

class FetchGameUseCase @Inject constructor(
    private val gameRepository: GameRepository,
){
    suspend operator fun invoke() = gameRepository.fetAndCacheGameLeagues()
}