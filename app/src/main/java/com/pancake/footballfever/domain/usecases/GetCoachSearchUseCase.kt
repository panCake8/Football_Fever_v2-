package com.pancake.footballfever.domain.usecases

import com.example.footboolfever.data.remote.dto.CoachsDto
import com.pancake.footballfever.data.repository.search.CoachSearchRepository
import com.pancake.footballfever.domain.models.SearchItem
import javax.inject.Inject

class GetCoachSearchUseCase  @Inject constructor(
    private val coachSearchRepository: CoachSearchRepository,
) {

    suspend operator fun invoke(name:String):List<SearchItem>{
        return coachSearchRepository.searchCoachs(name).map { it.toSearchItem() }
    }

    private fun CoachsDto.toSearchItem(): SearchItem {
        return SearchItem(
            id = this.id,
            name = this.name,
            logo = this.photo
        )
    }
}