package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.local.database.entity.FixtureSummaryEntity
import com.pancake.footballfever.data.repository.FixtureSummaryRepository
import com.pancake.footballfever.domain.models.FixtureSummary
import javax.inject.Inject

class GetFixtureSummaryUseCase @Inject constructor(
    private val repository: FixtureSummaryRepository,
) {
    suspend operator fun invoke(fixtureId: Int): List<FixtureSummary> {
        return repository.getSummaryFixtures(fixtureId).fold(
            onSuccess = { it.map { it.toDomain() } },
            onFailure = { throw it }
        )
    }

    private fun FixtureSummaryEntity.toDomain() =
        FixtureSummary(
            time = time,
            teamId = teamId,
            playerName = playerName,
            type = type,
            typeDetail = detail,
        )
}

