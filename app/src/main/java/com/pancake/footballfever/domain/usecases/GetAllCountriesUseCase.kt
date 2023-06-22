package com.pancake.footballfever.domain.usecases

import com.example.footboolfever.data.remote.dto.CountryDto
import com.pancake.footballfever.data.repository.CountryRepository
import com.pancake.footballfever.domain.models.SelectCountry
import javax.inject.Inject

class GetAllCountriesUseCase @Inject constructor(
    private val countryRepository: CountryRepository,
) {
    suspend fun getAllCountries(): List<SelectCountry> {
        return countryRepository.getAllCountriesRemote().map { it.toSelectCountry() }
    }

    private fun CountryDto.toSelectCountry(): SelectCountry {
        return SelectCountry(
            flag = this.flag,
            name = this.name
        )
    }
}