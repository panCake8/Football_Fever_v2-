package com.example.footboolfever.data.remote.dto

import com.example.footboolfever.data.remote.dto.utils.ExtraTime
import com.example.footboolfever.data.remote.dto.utils.Fixture
import com.example.footboolfever.data.remote.dto.utils.FullTime
import com.example.footboolfever.data.remote.dto.utils.HalfTime
import com.example.footboolfever.data.remote.dto.utils.Teams
import com.google.gson.annotations.SerializedName
import com.pancake.footballfever.data.local.database.entity.FixtureEntity

data class FixturesDto(

    @field:SerializedName("fixture")
    val fixture: Fixture? = null,

    @field:SerializedName("score")
    val score: FixturesScore? = null,

    @field:SerializedName("teams")
    val teams: Teams? = null,

    @field:SerializedName("league")
    val league: FixturesLeague? = null,

    @field:SerializedName("goals")
    val goals: FixturesGoals? = null
)

data class FixturesScore(

    @field:SerializedName("halftime")
    val halftime: HalfTime? = null,

    @field:SerializedName("penalty")
    val penalty: FixturesPenalty? = null,

    @field:SerializedName("fulltime")
    val fulltime: FullTime? = null,

    @field:SerializedName("extratime")
    val extratime: ExtraTime? = null
)

data class FixturesPenalty(

    @field:SerializedName("home")
    val home: Int? = null,

    @field:SerializedName("away")
    val away: Int? = null,
)

data class FixturesGoals(

    @field:SerializedName("home")
    val home: Int? = null,

    @field:SerializedName("away")
    val away: Int? = null,
)

data class FixturesLeague(

    @field:SerializedName("country")
    val country: String? = null,

    @field:SerializedName("round")
    val round: String? = null,

    @field:SerializedName("flag")
    val flag: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("logo")
    val logo: String? = null,

    @field:SerializedName("season")
    val season: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null
)

fun FixturesDto.toFixtureEntity(): FixtureEntity {
    return FixtureEntity(
        id = fixture?.id,
        date = fixture?.date,
        timeStamp = fixture?.timestamp,
        venueName = fixture?.venue?.name,
        leagueId = league?.id,
        country = league?.country,
        leagueName = league?.name,
        logo = league?.logo,
        round = league?.round,
        season = league?.season,
        teamHomeId = teams?.home?.id,
        teamAwayId = teams?.away?.id,
        teamHomeName = teams?.home?.name,
        teamAwayName = teams?.away?.name,
        teamHomeLogo = teams?.home?.logo,
        teamAwayLogo = teams?.away?.logo,
        teamHomeGoals = goals?.home,
        teamAwayGoals = goals?.away,
    )
}
