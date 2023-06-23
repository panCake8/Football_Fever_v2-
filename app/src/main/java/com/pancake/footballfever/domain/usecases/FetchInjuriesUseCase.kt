package com.pancake.footballfever.domain.usecases

import javax.inject.Inject

class FetchInjuriesUseCase @Inject constructor(
    private val injuriesRepository: InjuriesRepository
) {

    suspend operator fun invoke() = injuriesRepository.fetchInjuriesAndCache(2,2022)
}