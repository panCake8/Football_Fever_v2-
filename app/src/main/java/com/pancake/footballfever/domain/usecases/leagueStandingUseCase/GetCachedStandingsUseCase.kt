package com.pancake.footballfever.domain.usecases.leagueStandingUseCase

import com.pancake.footballfever.data.repository.StandingsRepository
import com.pancake.footballfever.utilities.toStandings
import javax.inject.Inject

class GetCachedStandingsUseCase @Inject constructor(
    private val standingsRepository: StandingsRepository
) {
    suspend operator fun invoke(leagueId: Int, season: Int) =
        standingsRepository.getCachedStandings(leagueId, season) .map { it.toStandings() }

}
