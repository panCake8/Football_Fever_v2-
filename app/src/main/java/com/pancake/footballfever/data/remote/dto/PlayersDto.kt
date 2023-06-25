package com.pancake.footballfever.data.remote.dto

import com.example.footboolfever.data.remote.dto.utils.Player
import com.example.footboolfever.data.remote.dto.utils.StatisticsItem
import com.google.gson.annotations.SerializedName

data class PlayersDto(

	@field:SerializedName("player")
	val player: Player? = null,

	@field:SerializedName("statistics")
	val statistics: List<StatisticsItem?>? = null
)


