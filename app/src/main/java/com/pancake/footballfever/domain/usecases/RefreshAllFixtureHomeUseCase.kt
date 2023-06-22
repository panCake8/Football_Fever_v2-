package com.pancake.footballfever.domain.usecases

import android.util.Log
import com.example.footboolfever.data.remote.dto.FixturesDto
import com.pancake.footballfever.data.local.database.entity.FavoriteTeamEntity
import com.pancake.footballfever.data.local.database.entity.FixtureHomeEntity
import com.pancake.footballfever.data.repository.FixtureRepository
import com.pancake.footballfever.data.repository.TeamRepository
import java.util.function.LongFunction
import javax.inject.Inject

class RefreshAllFixtureHomeUseCase @Inject constructor(
    private val teamRepository: TeamRepository,
    private val fixtureRepository: FixtureRepository,
) {

    private suspend fun getAllFavoriteTeams(): List<FavoriteTeamEntity> {
        return teamRepository.getAllFavoriteTeamsLocal()
    }

    suspend fun refreshAllFixtureHome(date: String, season: Int): Result<List<FixtureHomeEntity>> {
        return try {
            val teams = mutableListOf<FixtureHomeEntity>()
            getAllFavoriteTeams().forEach {
                val team = fixtureRepository.getAllFixturesHomeRemote(date, it.teamId!!, season)
                    .map { it.toFixtureEntity() }

                teams.addAll(team)
            }
            fixtureRepository.addFixtureHome(teams.distinctBy { it.fixture })
            Result.success(teams)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }

    private fun FixturesDto.toFixtureEntity(): FixtureHomeEntity {
        return FixtureHomeEntity(
            id = 0,
            fixture = this.fixture?.id,
            leagueName = this.league?.name,
            round = this.league?.round,
            elapsed = this.fixture?.status?.elapsed,
            status = this.fixture?.status?.jsonMemberLong,
            timestamp = this.fixture?.timestamp?.toLong(),
            homeTeamId = this.teams?.home?.id,
            homeTeamName = this.teams?.home?.name,
            homeTeamLogo = this.teams?.home?.logo,
            homeTeamGoals = this.goals?.home,
            awayTeamId = this.teams?.away?.id,
            awayTeamName = this.teams?.away?.name,
            awayTeamLogo = this.teams?.away?.logo,
            awayTeamGoals = this.goals?.away
        )
    }
}