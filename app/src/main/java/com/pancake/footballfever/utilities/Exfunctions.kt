package com.pancake.footballfever.utilities

import com.pancake.footballfever.data.local.database.entity.TopAssistEntity
import com.pancake.footballfever.data.local.database.entity.TopGoalsEntity
import com.pancake.footballfever.domain.models.TopAssists
import com.pancake.footballfever.domain.models.TopGoals

fun TopGoalsEntity.toTopGoals(): TopGoals {
    return TopGoals(
        id = this.id,
        playerName = this.playerName,
        teamName = this.teamName,
        totalGoals = this.totalGoals,
        playerImg = this.playerImg,
    )
}

fun TopAssistEntity.toTopAssist(): TopAssists {
    return TopAssists(
        id = this.id,
        playerName = this.playerName,
        teamName = this.teamName,
        totalAssists = this.totalAssists,
        playerImg = this.playerImg,
    )
}