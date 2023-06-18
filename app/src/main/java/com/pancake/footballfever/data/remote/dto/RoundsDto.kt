package com.example.footboolfever.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RoundsDto(

	@field:SerializedName("response")
	val rounds: List<String?>? = null,

)


