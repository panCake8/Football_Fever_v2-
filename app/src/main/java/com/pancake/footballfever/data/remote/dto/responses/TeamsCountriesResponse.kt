package com.example.footboolfever.data.remote.dto.responses

import com.example.footboolfever.data.remote.dto.CountryDto
import com.google.gson.annotations.SerializedName

data class TeamsCountriesResponse(

    @field:SerializedName("response")
	val response: List<CountryDto?>? = null,

    @field:SerializedName("parameters")
	val parameters: TeamsCountriesParameters? = null,
)

data class TeamsCountriesParameters(

	@field:SerializedName("id")
	val id: Int? = null
)
