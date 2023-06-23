package com.pancake.footballfever.domain.models

data class Fixture(
    val timestamp: Int = -1,

    val homeId: Int = -1,
    val homeName: String = "",
    val homeLogo: String = "",
    val homeGoals: Int = 0,
    val homeIsWinner: Boolean = false,

    val awayId: Int = -1,
    val awayName: String = "",
    val awayLogo: String = "",
    val awayGoals: Int = 0,
    val awayIsWinner: Boolean = false,
)
