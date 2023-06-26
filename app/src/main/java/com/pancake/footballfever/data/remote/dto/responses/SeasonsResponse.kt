package com.pancake.footballfever.data.remote.dto.responses

import com.google.gson.annotations.SerializedName

data class SeasonsResponse(

	@field:SerializedName("response")
	val response: List<Int?>? = null,
)
