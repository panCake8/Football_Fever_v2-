package com.pancake.footballfever.domain.usecases.injuriesUseCase

import com.pancake.footballfever.data.repository.InjuriesRepository
import javax.inject.Inject

class FetchInjuriesUseCase @Inject constructor(
    private val injuriesRepository: InjuriesRepository
) {

    suspend operator fun invoke() = injuriesRepository.fetchInjuriesAndCache(2,2022)
}