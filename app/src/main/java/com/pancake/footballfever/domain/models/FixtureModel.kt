package com.pancake.footballfever.domain.models

data class FixtureModel(
    val teamHomeId: Int? = null,
    val teamAwayId: Int? = null,
    val leagueId: Int? = null,
    val season: Int? = null,
    val teamHomeName: String? = null,
    val teamAwayName: String? = null,
    val teamHomeLogo: String? = null,
    val teamAwayLogo: String? = null,
    val teamHomeGoals: Int? = null,
    val teamAwayGoals: Int? = null,
    val timeStamp: Int? = null,
    val time: Int? = null,
    val id: Int? = null,
)
