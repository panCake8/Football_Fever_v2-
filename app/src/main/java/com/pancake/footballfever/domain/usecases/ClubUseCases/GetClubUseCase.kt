package com.pancake.footballfever.domain.usecases.ClubUseCases

import com.pancake.footballfever.data.repository.clubRepo.IClubRepository
import com.pancake.footballfever.domain.mappers.club.ClubDtoToUiMapper
import javax.inject.Inject

class GetClubUseCase @Inject constructor(
    private val clubRepository: IClubRepository,
    private val clubMap:ClubDtoToUiMapper
    ) {

    suspend operator fun invoke (clubId:Int) =
        clubRepository.getClubById(clubId).map(clubMap::map)
}