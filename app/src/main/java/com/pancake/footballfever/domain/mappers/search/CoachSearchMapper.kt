package com.pancake.footballfever.domain.mappers.search

import com.example.footboolfever.data.remote.dto.CoachsDto
import com.pancake.footballfever.domain.mappers.Mapper
import com.pancake.footballfever.domain.models.SearchItem

class CoachSearchMapper: Mapper<CoachsDto, SearchItem> {
    override fun map(input: CoachsDto): SearchItem {
        return SearchItem(
            id = input.id,
            name = input.name,
            logo = input.photo
        )
    }
}