package com.pancake.footballfever.domain.usecase

import com.pancake.footballfever.data.repository.StandingsRepository
import javax.inject.Inject

class GetCachedStandingsUseCase @Inject constructor(
    private val standingsRepository: StandingsRepository
){
    suspend operator fun invoke(leagueId:Int,season:Int) =
        standingsRepository.getCachedStandings(leagueId,season)

}
