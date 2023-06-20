package com.pancake.footballfever.domain.mappers.search

import com.example.footboolfever.data.remote.dto.league.LeaguesDto
import com.pancake.footballfever.domain.mappers.Mapper
import com.pancake.footballfever.domain.models.SearchItem

class LeagueSearchMapper: Mapper<LeaguesDto, SearchItem> {
    override fun map(input: LeaguesDto): SearchItem {
        return SearchItem(
            id = input.league?.id,
            name = input.league?.name,
            logo = input.league?.logo
        )
    }
}