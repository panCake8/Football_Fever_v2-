package com.example.footboolfever.data.remote.dto.standings

import com.google.gson.annotations.SerializedName

data class StandingsDto(
	@field:SerializedName("league")
	val league: League? = null
)


data class StandingsParameters(

	@field:SerializedName("league")
	val league: String? = null,

	@field:SerializedName("season")
	val season: String? = null
)

data class Goals(

	@field:SerializedName("against")
	val against: Int? = null,

	@field:SerializedName("for")
	val jsonMemberFor: Int? = null
)

data class All(

	@field:SerializedName("lose")
	val lose: Int? = null,

	@field:SerializedName("draw")
	val draw: Int? = null,

	@field:SerializedName("played")
	val played: Int? = null,

	@field:SerializedName("win")
	val win: Int? = null,

	@field:SerializedName("goals")
	val goals: Goals? = null
)

data class Home(

	@field:SerializedName("lose")
	val lose: Int? = null,

	@field:SerializedName("draw")
	val draw: Int? = null,

	@field:SerializedName("played")
	val played: Int? = null,

	@field:SerializedName("win")
	val win: Int? = null,

	@field:SerializedName("goals")
	val goals: Goals? = null
)

data class Away(

	@field:SerializedName("lose")
	val lose: Int? = null,

	@field:SerializedName("draw")
	val draw: Int? = null,

	@field:SerializedName("played")
	val played: Int? = null,

	@field:SerializedName("win")
	val win: Int? = null,

	@field:SerializedName("goals")
	val goals: Goals? = null
)

data class Team(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("logo")
	val logo: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class StandingsItemItem(

	@field:SerializedName("all")
	val all: All? = null,

	@field:SerializedName("away")
	val away: Away? = null,

	@field:SerializedName("form")
	val form: String? = null,

	@field:SerializedName("rank")
	val rank: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("update")
	val update: String? = null,

	@field:SerializedName("team")
	val team: Team? = null,

	@field:SerializedName("goalsDiff")
	val goalsDiff: Int? = null,

	@field:SerializedName("points")
	val points: Int? = null,

	@field:SerializedName("group")
	val group: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("home")
	val home: Home? = null
)

data class League(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("flag")
	val flag: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("logo")
	val logo: String? = null,

	@field:SerializedName("season")
	val season: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("standings")
	val standings: List<List<StandingsItemItem?>?>? = null
)
