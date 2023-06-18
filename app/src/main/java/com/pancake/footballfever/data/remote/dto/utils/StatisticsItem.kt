package com.example.footboolfever.data.remote.dto.utils

import com.example.footboolfever.data.remote.dto.Cards
import com.google.gson.annotations.SerializedName

data class StatisticsItem(

    @field:SerializedName("fouls")
    val fouls: Fouls? = null,

    @field:SerializedName("cards")
    val cards: Cards? = null,

    @field:SerializedName("dribbles")
    val dribbles: Dribbles? = null,

    @field:SerializedName("substitutes")
    val substitutes: Substitutes? = null,

    @field:SerializedName("penalty")
    val penalty: Penalty? = null,

    @field:SerializedName("league")
    val league: League? = null,

    @field:SerializedName("team")
    val team: Team? = null,

    @field:SerializedName("duels")
    val duels: Duels? = null,

    @field:SerializedName("passes")
    val passes: Passes? = null,

    @field:SerializedName("games")
    val games: Games? = null,

    @field:SerializedName("tackles")
    val tackles: Tackles? = null,

    @field:SerializedName("shots")
    val shots: Shots? = null,

    @field:SerializedName("goals")
    val goals: Goals? = null
)
