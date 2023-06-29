package com.pancake.footballfever.domain.usecases.searchUseCase

import com.example.footboolfever.data.remote.dto.teams.TeamsDto
import com.pancake.footballfever.data.repository.search.TeamSearchRepository
import com.pancake.footballfever.domain.models.SearchItem
import javax.inject.Inject

class GetTeamSearchUseCase  @Inject constructor(
    private val teamSearchRepository: TeamSearchRepository,
) {

   suspend operator fun invoke(name:String):List<SearchItem>{
       return teamSearchRepository.searchTeams(name).map{it.toSearchItem()}
   }

    private fun TeamsDto.toSearchItem():SearchItem{
        return SearchItem(
            id = this.team?.id,
            name = this.team?.name,
            logo = this.team?.logo
        )
    }

}