package com.example.footboolfever.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LineUpsDto(

	@field:SerializedName("substitutes")
	val substitutes: List<SubstitutesItem?>? = null,

	@field:SerializedName("startXI")
	val startXI: List<StartXIItem?>? = null,

	@field:SerializedName("team")
	val team: LineUpsTeam? = null,

	@field:SerializedName("formation")
	val formation: String? = null,

	@field:SerializedName("coach")
	val coach: Coach? = null
)
data class Colors(

	@field:SerializedName("goalkeeper")
	val goalkeeper: Goalkeeper? = null,

	@field:SerializedName("player")
	val player: LineUpsPlayer? = null
)

data class SubstitutesItem(

	@field:SerializedName("player")
	val player: LineUpsPlayer? = null
)

data class Coach(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class LineUpsTeam(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("logo")
	val logo: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("colors")
	val colors: Colors? = null
)

data class StartXIItem(

	@field:SerializedName("player")
	val player: LineUpsPlayer? = null
)

data class LineUpsPlayer(

	@field:SerializedName("border")
	val border: String? = null,

	@field:SerializedName("number")
	val number: Int? = null,

	@field:SerializedName("primary")
	val primary: String? = null,

	@field:SerializedName("pos")
	val pos: String? = null,

	@field:SerializedName("grid")
	val grid: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class Goalkeeper(

	@field:SerializedName("border")
	val border: String? = null,

	@field:SerializedName("number")
	val number: String? = null,

	@field:SerializedName("primary")
	val primary: String? = null
)
