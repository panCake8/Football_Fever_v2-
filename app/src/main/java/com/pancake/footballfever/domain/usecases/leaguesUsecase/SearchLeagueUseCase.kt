package com.pancake.footballfever.domain.usecases.leaguesUsecase

import com.pancake.footballfever.data.local.database.entity.LeagueEntity
import com.pancake.footballfever.data.repository.leagus.LeaguesRepository
import com.pancake.footballfever.domain.models.League
import javax.inject.Inject

class SearchLeagueUseCase @Inject constructor(
    private val leaguesRepository: LeaguesRepository,
) {

    suspend operator fun invoke(name: String): List<League> =
        leaguesRepository.searchLeaguesByName(name).map { it.toLeague() }


    fun LeagueEntity.toLeague(): League {
        return League(
            id = id,
            name = name,
            logo = logo,
            country = country,
            season = year,
            type = type,
        )
    }

}