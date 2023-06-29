package com.pancake.footballfever.domain.usecases.FixtureStasticsUseCases

import com.pancake.footballfever.data.repository.FixtureRepository
import com.pancake.footballfever.domain.models.FixtureStatistics
import javax.inject.Inject

class FetchFixtureStatisticsUseCase @Inject constructor(private val repository: FixtureRepository) {
    suspend operator fun invoke(fixtureId: Int): Result<FixtureStatistics?> =
        repository.getFixtureStatistics(fixtureId)
}