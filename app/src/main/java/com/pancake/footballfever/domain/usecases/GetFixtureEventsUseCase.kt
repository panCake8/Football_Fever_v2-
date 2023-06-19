package com.pancake.footballfever.domain.usecases

import com.example.footboolfever.data.remote.dto.EventsDto
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

    private fun EventsDto.toDomain() =
        FixtureEvents(
            time = time?.elapsed ?: 0,
            teamId = team?.id ?: -1,
            playerName = player?.name ?: "",
            type = type ?: "",
            typeDetail = detail ?: "",
        )
}

