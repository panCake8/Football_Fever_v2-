package com.pancake.footballfever.domain.usecase

import com.example.footboolfever.data.remote.dto.HeadToHeadDto
import com.pancake.footballfever.data.local.database.entity.HeadToHeadEntity
import com.pancake.footballfever.data.repository.HeadToHeadRepository
import com.pancake.footballfever.domain.models.HeadToHead
import com.pancake.footballfever.domain.models.HeadToHeadUiModel
import com.pancake.footballfever.domain.models.toHeadToHeadUiModel
import javax.inject.Inject

class GetHeadToHeadsUseCase @Inject constructor(
    private val repository: HeadToHeadRepository,
    private val cacheHeadToHeadsUseCase: CacheHeadToHeadsUseCase,
    private val deleteCachedHeadToHeadUseCase: DeleteCachedHeadToHeadUseCase,
    private val getCachedHeadToHeadsUseCase: GetCachedHeadToHeadsUseCase,
) {

    suspend fun getHeadToHeads(h2h: String): List<HeadToHeadUiModel>? {
        return try {
            val headToHeads = repository.fetchHeadToHeads(h2h)
            deleteCachedHeadToHeadUseCase.delete()
            cacheHeadToHeadsUseCase.cacheHeadToHeads(headToHeads)
            headToHeads?.map { it.toHeadToHead() }?.groupBy { it.season }?.toHeadToHeadUiModel()
                ?.sortedByDescending { it.season }
        } catch (e: Exception) {
            getCachedHeadToHeadsUseCase.getHeadToHeads()?.map { it.toHeadToHead() }
                ?.groupBy { it.season }?.toHeadToHeadUiModel()?.sortedByDescending { it.season }
        }
    }

    private fun HeadToHeadEntity.toHeadToHead(): HeadToHead {
        return HeadToHead(
            homeTeamGoals = homeTeamGoals,
            homeTeamName = homeTeamName,
            homeTeamLogo = homeTeamLogo,
            awayTeamGoals = awayTeamGoals,
            awayTeamName = awayTeamName,
            awayTeamLogo = awayTeamLogo,
            season = season,
            leagueLogo = leagueLogo,

            )
    }

    private fun HeadToHeadDto.toHeadToHead(): HeadToHead {
        return HeadToHead(
            homeTeamGoals = goals?.home.toString(),
            homeTeamName = teams?.home?.name,
            homeTeamLogo = teams?.home?.logo,
            awayTeamGoals = goals?.away.toString(),
            awayTeamName = teams?.away?.name,
            awayTeamLogo = teams?.away?.logo,
            season = league?.season,
            leagueLogo = league?.logo,
        )
    }

}