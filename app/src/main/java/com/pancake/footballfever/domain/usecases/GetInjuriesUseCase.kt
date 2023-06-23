package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.local.database.entity.toInjuriesModel
import javax.inject.Inject

class GetInjuriesUseCase @Inject constructor(
    private val injuriesRepository: InjuriesRepository
) {

    suspend operator fun invoke() = injuriesRepository.getCachedInjuries().map {
        it.toInjuriesModel()
    }
}