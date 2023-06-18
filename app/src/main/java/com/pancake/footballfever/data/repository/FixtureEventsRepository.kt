package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.EventsDto

interface FixtureEventsRepository {
    suspend fun getEventsFixtures(fixtureId: String): Result<List<EventsDto>>
}