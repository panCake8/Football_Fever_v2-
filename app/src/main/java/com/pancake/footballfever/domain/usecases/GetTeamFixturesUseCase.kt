package com.pancake.footballfever.domain.usecases

import com.example.footboolfever.data.remote.dto.FixturesDto
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
            onSuccess = {
                it.map { it.toDomain() }

            }, onFailure = {
                throw it
            }
        )
    }

    private fun FixturesDto.toDomain(): Fixture {
        return Fixture(
            timestamp = fixture?.timestamp!!,
            homeId = teams?.home?.id!!,
            homeName = teams.home.name!!,
            homeLogo = teams.home.logo!!,
            homeGoals = goals?.home ?: 0,
            homeIsWinner = teams.home.winner ?: false,
            awayId = teams.away?.id!!,
            awayName = teams.away.name!!,
            awayLogo = teams.away.logo!!,
            awayGoals = goals?.away ?: 0,
            awayIsWinner = teams.away.winner ?: false
        )
    }
}
