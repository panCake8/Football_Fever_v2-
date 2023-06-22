package com.pancake.footballfever.domain.usecases.ClubUseCases

import com.pancake.footballfever.data.repository.clubRepo.ClubRepository
import com.pancake.footballfever.domain.models.ClubModel
import com.pancake.footballfever.domain.models.toClubModel
import javax.inject.Inject

class GetClubUseCase @Inject constructor(
    private val clubRepository: ClubRepository,
    private val cacheDataUseCase: CacheClubDataUseCase,
    private val getCacheDataUseCase: GetCacheDataUseCase,
    private val deleteClubDataCachedUseCase: DeleteClubDataCachedUseCase,

    ) {

    suspend fun getClubById(clubId: Int):ClubModel{
        deleteClubDataCachedUseCase.invoke()
        val result = clubRepository.getClubById(clubId).toClubModel()
        cacheDataUseCase.addClubData(result)
        return getCacheDataUseCase.getCacheData()
    }
}