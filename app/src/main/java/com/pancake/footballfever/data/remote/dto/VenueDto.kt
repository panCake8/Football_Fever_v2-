package com.example.footboolfever.data.remote.dto

import com.google.gson.annotations.SerializedName



data class VenueDto(

	@field:SerializedName("country")
	val country: String? = null,

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
