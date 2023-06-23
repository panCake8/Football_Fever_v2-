package com.pancake.footballfever.domain.usecases.leaguesUsecase

import com.pancake.footballfever.data.local.database.entity.LeagueEntity
import com.pancake.footballfever.data.repository.LeaguesRepository
import com.pancake.footballfever.domain.models.League
import javax.inject.Inject

class GetCachedLeagueByIdUseCase @Inject constructor(
    private val leaguesRepository: LeaguesRepository,
) {

    suspend operator fun invoke(LeagueId: Int): League {
        val league = leaguesRepository.getLeaguesByIdLocally(LeagueId)
        return mapEntityToLeague(league)
    }

    private fun mapEntityToLeague(input: LeagueEntity): League {
        return League(
            id = input.id,
            name = input.name,
            logo = input.logo,
            country = input.country,
            season = input.year,
            type = input.type,
        )
    }
}