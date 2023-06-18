package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.local.database.entity.VenueEntity
import com.example.footboolfever.data.remote.dto.BaseResponse
import com.example.footboolfever.data.remote.dto.VenueDto
import retrofit2.Response

interface VenuesRepository {

    suspend fun getAllVenues(): Response<BaseResponse<VenueDto>>

    suspend fun insertAllVenues(venues: List<VenueEntity>)

    suspend fun getAllCachedVenues(): List<VenueEntity>

    suspend fun getVenuesById( id: Int ): Response<VenueDto> // not needed

    suspend fun getCachedVenuesById( id: Int ): VenueEntity

    suspend fun searchVenuesByNameCityCountry( search: String ): Response<VenueDto>
}