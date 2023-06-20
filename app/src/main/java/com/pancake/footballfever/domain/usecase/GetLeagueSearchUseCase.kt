package com.pancake.footballfever.domain.usecase

import com.pancake.footballfever.data.repository.search.LeagueSearchRepository
import com.pancake.footballfever.domain.mappers.search.LeagueSearchMapper
import com.pancake.footballfever.domain.models.SearchItem
import javax.inject.Inject

class GetLeagueSearchUseCase  @Inject constructor(
    private val leagueSearchRepository: LeagueSearchRepository,
    private val leagueSearchMapper: LeagueSearchMapper
) {

    suspend operator fun invoke(name:String):List<SearchItem>{
        return leagueSearchRepository.searchLeagues(name).map(leagueSearchMapper::map)
    }
}