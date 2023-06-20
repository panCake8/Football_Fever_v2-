package com.pancake.footballfever.domain.mappers.country

import com.example.footboolfever.data.remote.dto.CountryDto
import com.pancake.footballfever.domain.mappers.Mapper
import com.pancake.footballfever.domain.models.SelectCountry

class SelectCountryDtoToUiMapper : Mapper<CountryDto, SelectCountry> {
    override fun map(input: CountryDto): SelectCountry {
        return SelectCountry(
            flag = input.flag,
            name = input.name,
        )
    }
}