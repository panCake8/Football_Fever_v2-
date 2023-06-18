package com.example.footboolfever.data.remote.dto.responses

import com.google.gson.annotations.SerializedName

data class TeamsSeasonsResponse(

	@field:SerializedName("response")
	val response: List<Int?>? = null,

	@field:SerializedName("parameters")
	val parameters: TeamsSeasonsParameters? = null,

	)

data class TeamsSeasonsParameters(

	@field:SerializedName("team")
	val team: String? = null
)


