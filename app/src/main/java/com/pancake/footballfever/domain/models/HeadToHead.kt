package com.pancake.footballfever.domain.models

data class HeadToHead(
    val homeTeamGoals: String?,
    val homeTeamName: String?,
    val homeTeamLogo: String?,
    val awayTeamGoals: String?,
    val awayTeamName: String?,
    val awayTeamLogo: String?,
    val season: Int?,
    val leagueLogo: String?,
    val id: Int?,
    val date: String?,
)
