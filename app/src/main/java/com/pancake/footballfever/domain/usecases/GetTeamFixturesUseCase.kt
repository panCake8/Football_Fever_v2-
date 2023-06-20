package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.local.database.entity.FixtureEntity
import com.pancake.footballfever.data.repository.TeamFixturesRepository
import com.pancake.footballfever.domain.models.Fixture
import javax.inject.Inject

class GetTeamFixturesUseCase @Inject constructor(
    private val repository: TeamFixturesRepository,
) {
    suspend operator fun invoke(
        season: String,
        team: String
    ): List<Fixture> {
        return repository.getFixtures(season, team).fold(
            onSuccess = { it.map { it.toDomain() } },
            onFailure = { throw it }
        )
    }

    private fun FixtureEntity.toDomain() =
        Fixture(
            timestamp = timestamp,
            homeId = homeId,
            homeName = homeName,
            homeLogo = homeLogo,
            homeGoals = homeGoals,
            homeIsWinner = homeIsWinner,
            awayId = awayId,
            awayName = awayName,
            awayLogo = awayLogo,
            awayGoals = awayGoals,
            awayIsWinner = awayIsWinner
        )

}
