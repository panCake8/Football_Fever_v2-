package com.pancake.footballfever.domain.usecase


import com.pancake.footballfever.data.local.database.entity.toCoachModel
import com.pancake.footballfever.data.repository.IListCoachRepository
import javax.inject.Inject

class GetCachedCoachUseCase @Inject constructor(
    private val coachRepository: IListCoachRepository
    )
{
    suspend operator fun invoke() = coachRepository.getCachedCoach().map {
        it.toCoachModel()
    }

}