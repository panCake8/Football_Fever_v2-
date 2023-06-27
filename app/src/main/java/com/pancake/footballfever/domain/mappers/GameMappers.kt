package com.pancake.footballfever.domain.mappers

import com.pancake.footballfever.data.local.database.entity.GameLeagueEntity
import com.pancake.footballfever.domain.models.League


// add your mappers here like this one

fun GameLeagueEntity.toLeagues(): League {
    return League(
        id = id,
        name = name,
        logo = logo,
        country = name,
        season = season,
        type = type,
    )
}

