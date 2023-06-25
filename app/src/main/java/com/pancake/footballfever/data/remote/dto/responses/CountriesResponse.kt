package com.pancake.footballfever.data.remote.dto.responses

import com.example.footboolfever.data.remote.dto.CountryDto
import com.google.gson.annotations.SerializedName

data class CountriesResponse(

    @field:SerializedName("response")
    val response: List<CountryDto?>? = null,
)