package com.example.footboolfever.data.remote.dto.responses

import com.example.footboolfever.data.remote.dto.VenueDto
import com.google.gson.annotations.SerializedName

data class VenuesResponse(

    @field:SerializedName("response")
    val response: List<VenueDto?>? = null,
)
