package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.local.database.entity.StandingsEntity
import com.pancake.footballfever.data.repository.StandingsRepository
import com.pancake.footballfever.domain.models.Standings
import javax.inject.Inject

class GetCachedStandingsUseCase @Inject constructor(
    private val standingsRepository: StandingsRepository
) {
    suspend operator fun invoke(leagueId: Int, season: Int) =
        standingsRepository.getCachedStandings(leagueId, season).mapping
}

private val List<StandingsEntity>.mapping: List<Standings>
    get() {
        return this.map {
            Standings(
                rank = it.rank,
                teamName = it.teamName,
                teamLogoUrl = it.teamLogoUrl,
                teamId = it.teamId,
                points = it.points,
                win = it.win,
                played = it.played
            )
        }

}
