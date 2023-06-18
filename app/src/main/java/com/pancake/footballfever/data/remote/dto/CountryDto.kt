package com.example.footboolfever.data.remote.dto

import com.google.gson.annotations.SerializedName



data class CountryDto(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("flag")
	val flag: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)

