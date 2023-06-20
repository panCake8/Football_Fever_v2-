package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.repository.StandingsRepository
import javax.inject.Inject

class FetchStandingsAndCacheUseCase @Inject constructor(
    private val standingsRepository: StandingsRepository
) {


    suspend operator fun invoke(leagueId: Int, season: Int) =
        standingsRepository.fetchStandingsAndCache(leagueId, season)

}