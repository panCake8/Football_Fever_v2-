package com.example.footboolfever.data.remote.dto

import com.example.footboolfever.data.remote.dto.utils.Dribbles
import com.example.footboolfever.data.remote.dto.utils.Duels
import com.example.footboolfever.data.remote.dto.utils.Fouls
import com.example.footboolfever.data.remote.dto.utils.Goals
import com.example.footboolfever.data.remote.dto.utils.Passes
import com.example.footboolfever.data.remote.dto.utils.Penalty
import com.example.footboolfever.data.remote.dto.utils.Shots
import com.example.footboolfever.data.remote.dto.utils.Tackles
import com.google.gson.annotations.SerializedName

data class PlayerStatisticsDto(

	@field:SerializedName("players")
	val players: List<StatisticPlayersItem?>? = null,

	@field:SerializedName("team")
	val team: PlayerStatisticTeam? = null
)

data class StatisticPlayersItem(

	@field:SerializedName("player")
	val player: StatisticsPlayer? = null,

	@field:SerializedName("statistics")
	val statistics: List<PlayersStatisticsItem?>? = null
)

data class PlayersStatisticsItem(

	@field:SerializedName("fouls")
	val fouls: Fouls? = null,

	@field:SerializedName("cards")
	val cards: Cards? = null,

	@field:SerializedName("passes")
	val passes: Passes? = null,

	@field:SerializedName("dribbles")
	val dribbles: Dribbles? = null,

	@field:SerializedName("penalty")
	val penalty: Penalty? = null,

	@field:SerializedName("games")
	val games: PlayerStatisticsGames? = null,

	@field:SerializedName("tackles")
	val tackles: Tackles? = null,

	@field:SerializedName("shots")
	val shots: Shots? = null,

	@field:SerializedName("duels")
	val duels: Duels? = null,

	@field:SerializedName("offsides")
	val offsides: Any? = null,

	@field:SerializedName("goals")
	val goals: Goals? = null
)


data class PlayerStatisticsGames(

	@field:SerializedName("number")
	val number: Int? = null,

	@field:SerializedName("minutes")
	val minutes: Int? = null,

	@field:SerializedName("rating")
	val rating: String? = null,

	@field:SerializedName("position")
	val position: String? = null,

	@field:SerializedName("captain")
	val captain: Boolean? = null,

	@field:SerializedName("substitute")
	val substitute: Boolean? = null
)


data class StatisticsPlayer(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)


data class PlayerStatisticTeam(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("logo")
	val logo: String? = null,

	@field:SerializedName("update")
	val update: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class Cards(

	@field:SerializedName("red")
	val red: Int? = null,

	@field:SerializedName("yellow")
	val yellow: Int? = null
)
