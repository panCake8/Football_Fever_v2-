package com.example.footboolfever.data.remote.dto.teams

import com.google.gson.annotations.SerializedName



data class TeamsDto(

	@field:SerializedName("venue")
	val venue: Venue? = null,

	@field:SerializedName("team")
	val team: Team? = null
)

data class Venue(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("surface")
	val surface: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("capacity")
	val capacity: Int? = null
)

data class Team(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("founded")
	val founded: Int? = null,

	@field:SerializedName("national")
	val national: Boolean? = null,

	@field:SerializedName("logo")
	val logo: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)