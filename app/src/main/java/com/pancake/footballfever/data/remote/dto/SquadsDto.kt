package com.example.footboolfever.data.remote.dto

import com.example.footboolfever.data.remote.dto.utils.Team
import com.google.gson.annotations.SerializedName

data class SquadsDto(

	@field:SerializedName("players")
	val players: List<SquadsPlayersItem?>? = null,

	@field:SerializedName("team")
	val team: Team? = null
)

data class SquadsPlayersItem(

	@field:SerializedName("number")
	val number: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("position")
	val position: String? = null,

	@field:SerializedName("age")
	val age: Int? = null
)

