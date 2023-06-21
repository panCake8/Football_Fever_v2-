package com.pancake.footballfever.domain.usecases.fixutreUseCases

import com.pancake.footballfever.data.local.database.entity.toFixtureModel
import com.pancake.footballfever.data.repository.FixtureRepository
import javax.inject.Inject

class GetCachedFixtureUseCase @Inject constructor(
    private val repository: FixtureRepository
) {
    suspend operator fun invoke() = repository.getFixtureCachedData().map {
        it.toFixtureModel()
    }
}