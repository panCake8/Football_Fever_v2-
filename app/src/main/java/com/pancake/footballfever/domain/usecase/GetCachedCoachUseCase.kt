package com.pancake.footballfever.domain.usecase

import com.pancake.footballfever.data.local.database.entity.CoachEntity
import com.pancake.footballfever.data.repository.ListCoachRepository
import javax.inject.Inject

class GetCachedCoachUseCase @Inject constructor(
    private val coachRepository: ListCoachRepository
    )
{
    suspend operator fun invoke(): List<CoachEntity> {
        return coachRepository.getCachedCoach()
    }
}