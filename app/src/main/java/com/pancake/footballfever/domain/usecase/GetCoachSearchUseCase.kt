package com.pancake.footballfever.domain.usecase

import com.pancake.footballfever.data.repository.search.CoachSearchRepository
import com.pancake.footballfever.domain.mappers.search.CoachSearchMapper
import com.pancake.footballfever.domain.models.SearchItem
import javax.inject.Inject

class GetCoachSearchUseCase  @Inject constructor(
    private val coachSearchRepository: CoachSearchRepository,
    private val coachSearchMapper: CoachSearchMapper
) {

    suspend operator fun invoke(name:String):List<SearchItem>{
        return coachSearchRepository.searchCoachs(name).map(coachSearchMapper::map)
    }
}