package com.pancake.footballfever.data.local.mappers.playerMapper

import com.example.footboolfever.data.local.database.entity.TopAssistEntity
import com.example.footboolfever.data.remote.dto.TopAssistsDto
import com.pancake.footballfever.data.local.mappers.Mapper
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class TopAssistsMapper @Inject constructor(): Mapper<TopAssistsDto, TopAssistEntity> {

    override fun map(input: TopAssistsDto): TopAssistEntity {
        return TopAssistEntity(
            id = input.player?.id,
            playerName = input.player?.name,
            teamName = input.statistics?.get(0)?.team?.name,
            totalAssists = input.statistics?.get(0)?.passes?.total
        )
    }
}