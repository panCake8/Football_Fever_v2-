package com.pancake.footballfever.domain.models

data class FixtureHome(
    val leagueName: String?,
    val round: String?,
    val elapsed: Int?,
    val fixture: Int?,
    val status : String?,
    val homeTeamId: Int?,
    val homeTeamName: String?,
    val homeTeamLogo: String?,
    val homeTeamGoals: Int?,
    val awayTeamId: Int?,
    val awayTeamName: String?,
    val awayTeamLogo: String?,
    val awayTeamGoals: Int?
)
