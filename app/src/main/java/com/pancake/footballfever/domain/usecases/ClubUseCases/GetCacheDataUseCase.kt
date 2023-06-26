package com.pancake.footballfever.domain.usecases.ClubUseCases

import com.pancake.footballfever.data.local.database.entity.toClubModel
import com.pancake.footballfever.data.repository.clubRepo.ClubRepository
import com.pancake.footballfever.domain.models.ClubModel
import javax.inject.Inject

class GetCacheDataUseCase @Inject constructor(
    private val clubRepository: ClubRepository
) {
    suspend fun getCacheData ():ClubModel{
        return clubRepository.getLocalClubData().toClubModel()
    }
}