package com.pancake.footballfever.domain.usecase


import com.pancake.footballfever.data.repository.IListCoachRepository
import javax.inject.Inject

class FetchCoachUseCase @Inject constructor(
    private val coachRepository: IListCoachRepository
    )
{
    suspend operator fun invoke() = coachRepository.fetchCoachAndCache()

}