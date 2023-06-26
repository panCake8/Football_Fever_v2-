package com.pancake.footballfever.domain.usecases.ClubUseCases

import com.pancake.footballfever.data.local.database.entity.toClubEntity
import com.pancake.footballfever.data.repository.clubRepo.ClubRepository
import com.pancake.footballfever.domain.models.ClubModel
import javax.inject.Inject

class CacheClubDataUseCase @Inject constructor(
    private val clubRepository: ClubRepository,

) {
    suspend fun addClubData(clubData:ClubModel){
        clubRepository.addClubData(clubData.toClubEntity())
    }

}