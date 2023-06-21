package com.pancake.footballfever.domain.usecases.fixutreUseCases

import com.pancake.footballfever.data.repository.fixtureRepo.IFixtureRepository
import javax.inject.Inject

class FetchAndCacheFixtureUseCase @Inject constructor(
    private val repository: IFixtureRepository
) {
    suspend operator fun invoke(fixtureId: Int) = repository.fetchFixtureDataAndCache(fixtureId)
}