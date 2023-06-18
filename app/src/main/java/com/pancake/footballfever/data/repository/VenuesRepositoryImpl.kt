package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.local.database.entity.VenueEntity
import com.example.footboolfever.data.remote.dto.BaseResponse
import com.example.footboolfever.data.remote.dto.VenueDto
import com.pancake.footballfever.data.local.database.daos.FootballDao
import com.pancake.footballfever.data.remote.service.ApiService
import retrofit2.Response
import javax.inject.Inject

class VenuesRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dao: FootballDao
) : VenuesRepository {

    override suspend fun getAllVenues(): Response<BaseResponse<VenueDto>> =
        apiService.getAllVenues()

    override suspend fun insertAllVenues(venues: List<VenueEntity>) = dao.insertVenues(venues)

    override suspend fun getAllCachedVenues(): List<VenueEntity> = dao.getAllVenues()

    override suspend fun getCachedVenuesById(id: Int): VenueEntity = dao.getVenueById(id)

    override suspend fun getVenuesById(id: Int): Response<VenueDto> = apiService.getVenuesById(id)

    override suspend fun searchVenuesByNameCityCountry(search: String): Response<VenueDto> =
        apiService.searchVenuesByNameCityCountry(search)

}
