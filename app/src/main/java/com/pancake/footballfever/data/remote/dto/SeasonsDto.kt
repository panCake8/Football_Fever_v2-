package com.example.footboolfever.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SeasonsDto(

	@field:SerializedName("response")
	val seasons: List<Int?>? = null,

)
