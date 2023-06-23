package com.pancake.footballfever.domain.usecases


import com.pancake.footballfever.data.local.database.entity.FixtureHomeEntity
import com.pancake.footballfever.data.repository.FixtureRepository
import com.pancake.footballfever.domain.models.FixtureHome
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllFixtureHomeLocalUseCase @Inject constructor(
    private val fixtureRepository: FixtureRepository,
) {

    suspend fun getAllFixtureHomeLocal(): Flow<List<FixtureHome>> {
        return flow {
            fixtureRepository.getAllFixturesHomeLocal().collect { teams ->
                val localTeams = teams.sortedWith(compareBy { it.timestamp })
                    .map { it.toFixtureHome() }
                    .distinctBy { it.fixture }
                emit(localTeams)
            }
        }

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