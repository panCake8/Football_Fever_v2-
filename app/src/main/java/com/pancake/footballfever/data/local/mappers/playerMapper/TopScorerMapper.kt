package com.pancake.footballfever.data.local.mappers.playerMapper

import com.example.footboolfever.data.local.database.entity.TopScorerEntity
import com.example.footboolfever.data.remote.dto.TopScoresDto
import com.pancake.footballfever.data.local.mappers.Mapper
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class TopScorerMapper @Inject constructor(): Mapper<TopScoresDto, TopScorerEntity> {
    override fun map(input: TopScoresDto): TopScorerEntity {
        return TopScorerEntity(
            id = input.player?.id,
            playerName = input.player?.name,
            teamName = input.statistics?.get(0)?.team?.name,
        )
    }

}