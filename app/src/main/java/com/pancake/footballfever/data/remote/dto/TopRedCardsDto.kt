package com.example.footboolfever.data.remote.dto

import com.example.footboolfever.data.remote.dto.utils.Player
import com.google.gson.annotations.SerializedName

data class TopRedCardsDto(

	@field:SerializedName("player")
	val player: Player? = null,

	@field:SerializedName("statistics")
	val statistics: List<StatisticsItem?>? = null
)
