package com.pancake.footballfever.domain.models

import com.example.footboolfever.data.remote.dto.StatisticsDto

data class FixtureStatistics(
    val homeTeamShots: Int?,
    val homeTeamShotsOnTarget: Int?,
    val homeTeamBallPossession: String?,
    val homeTeamPasses: Int?,
    val homeTeamPassAccuracy: String?,
    val HomeTeamFouls: Int?,
    val HomeTeamYellowCards: Int?,
    val HomeTeamRedCards: Int?,
    val HomeTeamOffsides: Int?,
    val HomeTeamCornerKicks: Int?,

    val awayTeamShots: Int?,
    val awayTeamShotsOnTarget: Int?,
    val awayTeamBallPossession: String?,
    val awayTeamPasses: Int?,
    val awayTeamPassAccuracy: String?,
    val awayTeamFouls: Int?,
    val awayTeamYellowCards: Int?,
    val awayTeamRedCards: Int?,
    val awayTeamOffsides: Int?,
    val awayTeamCornerKicks: Int?,
)

fun List<StatisticsDto>.toFixtureStatistics(): FixtureStatistics {
    return FixtureStatistics(

        homeTeamShots = this[0].statistics?.get(2)?.value?.toInt(),
        homeTeamShotsOnTarget = this[0].statistics?.get(0)?.value?.toInt() ,
        homeTeamBallPossession = this[0].statistics?.get(9)?.value ,
        homeTeamPasses = this[0].statistics?.get(13)?.value?.toInt() ,
        homeTeamPassAccuracy = this[0].statistics?.get(15)?.value ,
        HomeTeamFouls = this[0].statistics?.get(6)?.value ?.toInt(),
        HomeTeamYellowCards = this[0].statistics?.get(10)?.value?.toInt(),
        HomeTeamRedCards = this[0].statistics?.get(11)?.value?.toInt(),
        HomeTeamOffsides = this[0].statistics?.get(8)?.value ?.toInt(),
        HomeTeamCornerKicks = this[0].statistics?.get(7)?.value?.toInt(),

        awayTeamShots = this[1].statistics?.get(2)?.value ?.toInt(),
        awayTeamShotsOnTarget = this[1].statistics?.get(0)?.value ?.toInt(),
        awayTeamBallPossession = this[1].statistics?.get(9)?.value ,
        awayTeamPasses = this[1].statistics?.get(13)?.value ?.toInt(),
        awayTeamPassAccuracy = this[1].statistics?.get(15)?.value ,
        awayTeamFouls = this[1].statistics?.get(6)?.value ?.toInt(),
        awayTeamYellowCards = this[1].statistics?.get(10)?.value ?.toInt(),
        awayTeamRedCards = this[1].statistics?.get(11)?.value ?.toInt(),
        awayTeamOffsides = this[1].statistics?.get(8)?.value ?.toInt(),
        awayTeamCornerKicks = this[1].statistics?.get(7)?.value ?.toInt(),

        )

}
