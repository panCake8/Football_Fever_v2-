package com.example.footboolfever.data.remote.dto

import com.example.footboolfever.data.remote.dto.utils.Dribbles
import com.example.footboolfever.data.remote.dto.utils.Duels
import com.example.footboolfever.data.remote.dto.utils.Fouls
import com.example.footboolfever.data.remote.dto.utils.Games
import com.example.footboolfever.data.remote.dto.utils.League
import com.example.footboolfever.data.remote.dto.utils.Passes
import com.example.footboolfever.data.remote.dto.utils.Penalty
import com.example.footboolfever.data.remote.dto.utils.Player
import com.example.footboolfever.data.remote.dto.utils.Shots
import com.example.footboolfever.data.remote.dto.utils.Substitutes
import com.example.footboolfever.data.remote.dto.utils.Tackles
import com.example.footboolfever.data.remote.dto.utils.Team
import com.google.gson.annotations.SerializedName


data class TopAssistsDto(

	@field:SerializedName("player")
	val player: Player? = null,

	@field:SerializedName("statistics")
	val statistics: List<TopAssistsStatisticsItem?>? = null
)

data class TopAssistsStatisticsItem(

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
	val goals: TopAssistsGoals? = null
)

data class TopAssistsGoals(

	@field:SerializedName("conceded")
	val conceded: Int? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("saves")
	val saves: Any? = null,

	@field:SerializedName("assists")
	val assists: Int? = null
)
