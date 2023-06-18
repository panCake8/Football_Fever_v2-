package com.example.footboolfever.data.remote.dto

import com.example.footboolfever.data.remote.dto.utils.Team
import com.google.gson.annotations.SerializedName

data class EventsDto(

	@field:SerializedName("comments")
	val comments: String? = null,

	@field:SerializedName("assist")
	val assist: Assist? = null,

	@field:SerializedName("time")
	val time: Time? = null,

	@field:SerializedName("team")
	val team: Team? = null,

	@field:SerializedName("detail")
	val detail: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("player")
	val player: EventsPlayer? = null
)

data class Assist(

	@field:SerializedName("name")
	val name: Any? = null,

	@field:SerializedName("id")
	val id: Any? = null
)


data class Time(

	@field:SerializedName("elapsed")
	val elapsed: Int? = null,

	@field:SerializedName("extra")
	val extra: Any? = null
)

data class EventsPlayer(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)