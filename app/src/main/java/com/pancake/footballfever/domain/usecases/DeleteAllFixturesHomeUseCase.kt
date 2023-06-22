package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.repository.FixtureRepository
import javax.inject.Inject

class DeleteAllFixturesHomeUseCase @Inject constructor(
    private val fixtureRepository: FixtureRepository
) {
    suspend operator fun invoke() {
        fixtureRepository.deleteAllHomeFixtures()
    }
}