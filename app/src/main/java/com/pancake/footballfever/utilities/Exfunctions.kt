package com.pancake.footballfever.utilities

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.footboolfever.data.remote.dto.standings.StandingsDto
import com.pancake.footballfever.data.local.database.entity.StandingsEntity
import com.pancake.footballfever.domain.models.Standings
import com.pancake.footballfever.data.local.database.entity.TopAssistEntity
import com.pancake.footballfever.data.local.database.entity.TopGoalsEntity
import com.pancake.footballfever.domain.models.TopAssists
import com.pancake.footballfever.domain.models.TopGoals
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
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

fun <T> LifecycleOwner.collectLast(flow: Flow<T>, action: suspend (T) -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collectLatest(action)
        }
    }
}

fun <T> LifecycleOwner.collect(flow: Flow<T>, action: suspend (T) -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collect {
                action.invoke(it)
            }
        }
    }
}