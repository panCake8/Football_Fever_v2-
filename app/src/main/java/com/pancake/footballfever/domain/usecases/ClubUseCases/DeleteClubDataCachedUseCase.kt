package com.pancake.footballfever.domain.usecases.ClubUseCases

import com.pancake.footballfever.data.repository.clubRepo.ClubRepository
import javax.inject.Inject

class DeleteClubDataCachedUseCase@Inject constructor(
   private val clubRepository: ClubRepository,
) {
    suspend operator fun invoke() {
        clubRepository.deleteClubData()
    }
}