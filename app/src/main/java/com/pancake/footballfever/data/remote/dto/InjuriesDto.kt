package com.example.footboolfever.data.remote.dto

import com.example.footboolfever.data.remote.dto.utils.League
import com.example.footboolfever.data.remote.dto.utils.Team
import com.google.gson.annotations.SerializedName

data class InjuriesDto(

	@field:SerializedName("fixture")
	val fixture: InjuriesFixture? = null,

	@field:SerializedName("league")
	val league: League? = null,

	@field:SerializedName("team")
	val team: Team? = null,

	@field:SerializedName("player")
	val player: InjuriesPlayer? = null
)

data class InjuriesFixture(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("timezone")
	val timezone: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("timestamp")
	val timestamp: Int? = null
)

data class InjuriesPlayer(

	@field:SerializedName("reason")
	val reason: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("type")
	val type: String? = null
)

