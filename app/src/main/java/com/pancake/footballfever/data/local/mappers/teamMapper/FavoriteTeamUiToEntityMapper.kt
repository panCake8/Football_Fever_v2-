package com.pancake.footballfever.data.local.mappers.teamMapper

import com.pancake.footballfever.data.local.database.entity.FavoriteTeamEntity
import com.pancake.footballfever.data.local.mappers.Mapper
import com.pancake.footballfever.domain.models.FavoriteTeam

class FavoriteTeamUiToEntityMapper : Mapper<FavoriteTeam, FavoriteTeamEntity> {
    override fun map(input: FavoriteTeam): FavoriteTeamEntity {
        return FavoriteTeamEntity(
            id = 0,
            teamId = input.id,
            name = input.name,
            logo = input.logo
        )
    }
}