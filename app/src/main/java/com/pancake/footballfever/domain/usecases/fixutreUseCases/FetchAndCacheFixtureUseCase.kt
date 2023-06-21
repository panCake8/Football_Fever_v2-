package com.pancake.footballfever.domain.usecases.fixutreUseCases

import com.pancake.footballfever.data.repository.FixtureRepository
import javax.inject.Inject

class FetchAndCacheFixtureUseCase @Inject constructor(
    private val repository: FixtureRepository
) {
    suspend operator fun invoke(fixtureId: Int) = repository.fetchFixtureDataAndCache(fixtureId)
}