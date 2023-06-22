package com.example.footboolfever.data.remote.dto.responses

import com.pancake.footballfever.data.remote.dto.league.LeaguesDto
import com.google.gson.annotations.SerializedName

data class LeaguesResponse(

	@field:SerializedName("response")
	val response: List<LeaguesDto?>? = null,
)