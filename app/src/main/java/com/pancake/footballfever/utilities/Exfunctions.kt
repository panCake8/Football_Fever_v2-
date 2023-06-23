package com.pancake.footballfever.utilities

import com.example.footboolfever.data.remote.dto.standings.StandingsDto
import com.pancake.footballfever.data.local.database.entity.StandingsEntity
import com.pancake.footballfever.domain.models.Standings
import com.pancake.footballfever.data.local.database.entity.TopAssistEntity
import com.pancake.footballfever.data.local.database.entity.TopGoalsEntity
import com.pancake.footballfever.domain.models.TopAssists
import com.pancake.footballfever.domain.models.TopGoals

fun StandingsDto.toStandingsEntity() :List<StandingsEntity>? {

    val standingsItemItem =league?.standings?.first()
    return standingsItemItem?.map  {
        StandingsEntity(
            teamId = it?.team?.id!!,
            leagueId = league?.id!!,
            season =league.season!!,
            rank =it.rank!!,
            teamName =it.team.name!!,
            teamLogoUrl =it.team.logo!!,
            points =it.points!!,
            win =it.all?.win!!,
            played = it.all.played!!,
        )
    }
}

fun StandingsEntity.toStandings(): Standings {
    return Standings(
        rank = rank,
        season= season,
        teamName = teamName,
        teamLogoUrl = teamLogoUrl,
        teamId = teamId,
        points = points,
        win = win,
        played = played
    )
}

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