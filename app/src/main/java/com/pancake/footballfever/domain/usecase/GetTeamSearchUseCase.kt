package com.pancake.footballfever.domain.usecase

import com.pancake.footballfever.data.repository.search.TeamSearchRepository
import com.pancake.footballfever.domain.mappers.search.TeamSearchMapper
import com.pancake.footballfever.domain.models.SearchItem
import javax.inject.Inject

class GetTeamSearchUseCase  @Inject constructor(
    private val teamSearchRepository: TeamSearchRepository,
    private val teamSearchMapper: TeamSearchMapper
) {

   suspend operator fun invoke(name:String):List<SearchItem>{
       return teamSearchRepository.searchTeams(name).map(teamSearchMapper::map)
   }
}