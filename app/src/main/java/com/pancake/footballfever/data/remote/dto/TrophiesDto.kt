package com.example.footboolfever.data.remote.dto

import com.google.gson.annotations.SerializedName


data class TrophiesDto(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("league")
	val league: String? = null,

	@field:SerializedName("season")
	val season: String? = null,

	@field:SerializedName("place")
	val place: String? = null
)
