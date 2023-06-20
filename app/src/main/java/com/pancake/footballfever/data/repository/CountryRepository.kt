package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.CountryDto

interface CountryRepository {

    suspend fun getAllCountriesRemote(): List<CountryDto>
}