package com.pancake.footballfever.domain.models

data class LeagueMatch(
    val date: String?,
    val homeTeamName: String?,
    val homeTeamLogo: String?,
    val awayTeamName: String?,
    val awayTeamLogo: String?,
    val matchTime: Int?,
)
