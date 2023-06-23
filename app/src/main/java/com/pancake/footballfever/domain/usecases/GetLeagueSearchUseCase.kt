package com.pancake.footballfever.domain.usecases

import com.example.footboolfever.data.remote.dto.league.LeaguesDto
import com.pancake.footballfever.data.repository.search.LeagueSearchRepository
import com.pancake.footballfever.domain.models.SearchItem
import javax.inject.Inject

class GetLeagueSearchUseCase  @Inject constructor(
    private val leagueSearchRepository: LeagueSearchRepository,
) {

    suspend operator fun invoke(name:String):List<SearchItem>{
        return leagueSearchRepository.searchLeagues(name).map { it.toSearchItem() }
    }
    private fun LeaguesDto.toSearchItem():SearchItem{
        return SearchItem(
            id = this.league?.id,
            name = this.league?.name,
            logo = this.league?.logo
        )
    }

}