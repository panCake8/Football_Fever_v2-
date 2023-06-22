package com.pancake.footballfever.domain.usecases


import com.pancake.footballfever.data.local.database.entity.FixtureHomeEntity
import com.pancake.footballfever.data.repository.FixtureRepository
import com.pancake.footballfever.domain.models.FixtureHome
import javax.inject.Inject

class GetAllFixtureHomeLocalUseCase @Inject constructor(
    private val fixtureRepository: FixtureRepository,
) {

    suspend fun getAllFixtureHomeLocal(): List<FixtureHome> {
        return fixtureRepository.getAllFixturesHomeLocal()
            .sortedWith(compareBy { it.timestamp })
            .map { it.toFixtureHome() }

    }
}

private fun FixtureHomeEntity.toFixtureHome(): FixtureHome {
    return FixtureHome(
        leagueName = this.leagueName,
        round = this.round,
        elapsed = this.elapsed,
        fixture = this.fixture,
        status = this.status,
        homeTeamId = this.homeTeamId,
        homeTeamName = this.homeTeamName,
        homeTeamLogo = this.homeTeamLogo,
        homeTeamGoals = this.homeTeamGoals,
        awayTeamId = this.awayTeamId,
        awayTeamName = this.awayTeamName,
        awayTeamLogo = this.awayTeamLogo,
        awayTeamGoals = this.awayTeamGoals,
    )
}