package com.pancake.footballfever.domain.usecases.fixutreUseCases

import com.pancake.footballfever.data.local.database.entity.toFixtureModel
import com.pancake.footballfever.data.repository.fixtureRepo.IFixtureRepository
import com.pancake.footballfever.domain.models.FixtureModel
import javax.inject.Inject

class GetCachedFixtureUseCase @Inject constructor(
    private val repository: IFixtureRepository
) {
    suspend operator fun invoke() = repository.getFixtureCachedData().map {
        it.toFixtureModel()
    }
}