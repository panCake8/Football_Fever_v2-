package com.pancake.footballfever.domain.usecases.ClubUseCases

import com.pancake.footballfever.data.local.database.entity.ClubEntity
import com.pancake.footballfever.data.repository.clubRepo.IClubRepository
import com.pancake.footballfever.domain.mappers.club.ClubDtoToUiMapper
import javax.inject.Inject

class ChacheClubDataUseCase @Inject constructor(
    private val clubRepository: IClubRepository,
    private val clubMap:ClubDtoToUiMapper,
) {
    suspend fun addClubData(clubData:ClubEntity){
        clubRepository.addClubData(clubData)
    }
}