package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.CountryDto
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
) : CountryRepository {

    override suspend fun getAllCountriesRemote(): List<CountryDto> {
        return apiService.getAllCountries().body()?.response!!
    }

}