package com.pancake.footballfever.domain.models

data class FixtureModel(
    val teamHomeId: Int? = null,
    val teamAwayId: Int? = null,
    val teamHomeLogo: String? = null,
    val teamAwayLogo: String? = null,
    val teamHomeGoals: Int? = null,
    val teamAwayGoals: Int? = null,
    val timeStamp: Int? = null,
)
