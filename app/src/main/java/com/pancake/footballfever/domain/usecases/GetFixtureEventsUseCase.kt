package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.local.database.entity.FixtureEventsEntity
import com.pancake.footballfever.data.repository.FixtureEventsRepository
import com.pancake.footballfever.domain.models.FixtureEvents
import javax.inject.Inject

class GetFixtureEventsUseCase @Inject constructor(
    private val repository: FixtureEventsRepository,
) {
    suspend operator fun invoke(fixtureId: String): List<FixtureEvents> {
        return repository.getEventsFixtures(fixtureId).fold(
            onSuccess = { it.map { it.toDomain() } },
            onFailure = { throw it }
        )
    }

    private fun FixtureEventsEntity.toDomain() =
        FixtureEvents(
            time = time,
            teamId = teamId,
            playerName = playerName,
            type = type,
            typeDetail = detail,
        )
}

