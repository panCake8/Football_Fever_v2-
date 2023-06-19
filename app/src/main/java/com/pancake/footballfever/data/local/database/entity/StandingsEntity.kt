package com.pancake.footballfever.data.local.database.entity

@Entity(tableName = "STANDINGS_TABLE")
data class StandingsEntity(
    @PrimaryKey
    val id: Int,
    val leagueId:Int,
    val season:Int,
    val teamId:Int,
    val rank: Int,
    val teamName:String,
    val teamLogoUrl:String,
    val points: Int,
    val win: Int,
    val played: Int,
)