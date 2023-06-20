package com.pancake.footballfever.domain.mappers.search

import com.example.footboolfever.data.remote.dto.teams.TeamsDto
import com.pancake.footballfever.domain.mappers.Mapper
import com.pancake.footballfever.domain.models.SearchItem

class TeamSearchMapper: Mapper<TeamsDto, SearchItem> {
    override fun map(input: TeamsDto): SearchItem {
        return SearchItem(
            id = input.team?.id,
            name = input.team?.name,
            logo = input.team?.logo
        )
    }
}