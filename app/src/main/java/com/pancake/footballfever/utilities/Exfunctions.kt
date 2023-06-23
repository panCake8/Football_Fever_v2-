package com.pancake.footballfever.utilities

import com.example.footboolfever.data.remote.dto.standings.StandingsDto
import com.pancake.footballfever.data.local.database.entity.StandingsEntity
import com.pancake.footballfever.domain.models.Standings
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

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


fun Int.toDate(): String {
    val calender = Calendar.getInstance()
    calender.timeInMillis = this.toLong()
    val format = SimpleDateFormat("HH:mm", Locale.getDefault())
    return format.format(calender.time)


}