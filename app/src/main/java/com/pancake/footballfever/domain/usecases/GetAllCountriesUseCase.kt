package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.repository.CountryRepository
import com.pancake.footballfever.domain.mappers.country.SelectCountryDtoToUiMapper
import com.pancake.footballfever.domain.models.SelectCountry
import javax.inject.Inject

class GetAllCountriesUseCase @Inject constructor(
    private val countryRepository: CountryRepository,
    private val countryMapper: SelectCountryDtoToUiMapper
) {
    suspend fun getAllCountries(): List<SelectCountry> {
        return countryRepository.getAllCountriesRemote().map(countryMapper::map)
    }
}