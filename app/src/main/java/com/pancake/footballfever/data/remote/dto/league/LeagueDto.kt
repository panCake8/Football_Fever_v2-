package com.pancake.footballfever.data.remote.dto.league

import com.google.gson.annotations.SerializedName

data class LeaguesDto(

	@field:SerializedName("country")
	val country: Country? = null,

	@field:SerializedName("seasons")
	val seasons: List<SeasonsItem?>? = null,

	@field:SerializedName("league")
	val league: League? = null
)

data class SeasonsItem(

	@field:SerializedName("coverage")
	val coverage: Coverage? = null,

	@field:SerializedName("current")
	val current: Boolean? = null,

	@field:SerializedName("year")
	val year: Int? = null,

	@field:SerializedName("start")
	val start: String? = null,

	@field:SerializedName("end")
	val end: String? = null
)

data class League(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("logo")
	val logo: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class Fixtures(

	@field:SerializedName("statistics_fixtures")
	val statisticsFixtures: Boolean? = null,

	@field:SerializedName("statistics_players")
	val statisticsPlayers: Boolean? = null,

	@field:SerializedName("events")
	val events: Boolean? = null,

	@field:SerializedName("lineups")
	val lineups: Boolean? = null
)

data class Coverage(

	@field:SerializedName("top_cards")
	val topCards: Boolean? = null,

	@field:SerializedName("injuries")
	val injuries: Boolean? = null,

	@field:SerializedName("players")
	val players: Boolean? = null,

	@field:SerializedName("odds")
	val odds: Boolean? = null,

	@field:SerializedName("top_assists")
	val topAssists: Boolean? = null,

	@field:SerializedName("standings")
	val standings: Boolean? = null,

	@field:SerializedName("top_scorers")
	val topScorers: Boolean? = null,

	@field:SerializedName("predictions")
	val predictions: Boolean? = null,

	@field:SerializedName("fixtures")
	val fixtures: Fixtures? = null
)

data class Country(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("flag")
	val flag: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)
