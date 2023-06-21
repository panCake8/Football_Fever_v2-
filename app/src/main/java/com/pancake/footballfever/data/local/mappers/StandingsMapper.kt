package com.pancake.footballfever.data.local.mappers

import com.example.footboolfever.data.remote.dto.standings.StandingsDto
import com.pancake.footballfever.data.local.database.entity.StandingsEntity

class StandingsMapper : Mapper<StandingsDto, List<StandingsEntity>?> {
    override fun map(input: StandingsDto): List<StandingsEntity>? {
        val standingsItemItem =input.league?.standings?.get(0)


        return standingsItemItem?.map  {
            StandingsEntity(
                teamId = it?.team?.id!!,
                leagueId = input.league.id!!,
                season =input.league.season!!,
                rank =it.rank!!,
                teamName =it.team.name!!,
                teamLogoUrl =it.team.logo!!,
                points =it.points!!,
                win =it.all?.win!!,
                played = it.all?.played!!,
            )
        }


    }

}