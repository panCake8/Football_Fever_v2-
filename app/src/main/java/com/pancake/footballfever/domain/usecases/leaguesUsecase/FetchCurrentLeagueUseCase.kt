package com.pancake.footballfever.domain.usecases.leaguesUsecase

import com.pancake.footballfever.data.repository.LeaguesRepository
import javax.inject.Inject

class FetchCurrentLeagueUseCase @Inject constructor(
    private val leaguesRepository: LeaguesRepository,
) {
    suspend operator fun invoke() = leaguesRepository.fetchCurrentLeaguesDataAndCache(true)

}