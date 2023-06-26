package com.pancake.footballfever.domain.usecase

import com.example.footboolfever.data.remote.dto.HeadToHeadDto
import com.pancake.footballfever.data.local.database.daos.HeadToHeadDao
import com.pancake.footballfever.data.local.database.entity.HeadToHeadEntity
import javax.inject.Inject

class CacheHeadToHeadsUseCase @Inject constructor(private val dao: HeadToHeadDao) {

    suspend fun cacheHeadToHeads(list: List<HeadToHeadDto>?) {
        return dao.addHeadToHeads(list?.map { it.toHeadToHeadEntity() })
    }
}

private fun HeadToHeadDto.toHeadToHeadEntity(): HeadToHeadEntity {
    return HeadToHeadEntity(
        awayTeamLogo = teams?.away?.logo,
        id = fixture?.id,
        homeTeamName = teams?.home?.name,
        awayTeamName = teams?.away?.name,
        homeTeamLogo = teams?.home?.logo,
        leagueLogo = league?.logo,
        awayTeamGoals = goals?.away.toString(),
        homeTeamGoals = goals?.home.toString(),
        season = league?.season,
        date = fixture?.date?.take(10),

    )

}