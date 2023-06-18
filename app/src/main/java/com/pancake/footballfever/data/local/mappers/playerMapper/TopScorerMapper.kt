package com.pancake.footballfever.data.local.mappers.playerMapper

import com.pancake.footballfever.data.local.database.entity.TopGoalsEntity
import com.example.footboolfever.data.remote.dto.TopScoresDto
import com.pancake.footballfever.data.local.mappers.Mapper
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class TopScorerMapper @Inject constructor(): Mapper<TopScoresDto, TopGoalsEntity> {
    override fun map(input: TopScoresDto): TopGoalsEntity {
        return TopGoalsEntity(
            id = input.player?.id,
            playerName = input.player?.name,
            teamName = input.statistics?.get(0)?.team?.name,
        )
    }

}