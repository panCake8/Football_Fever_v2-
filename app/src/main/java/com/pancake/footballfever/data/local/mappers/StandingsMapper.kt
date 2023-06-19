package com.pancake.footballfever.data.local.mappers

import com.example.footboolfever.data.remote.dto.standings.StandingsDto
import com.pancake.footballfever.data.local.database.entity.StandingsEntity

class StandingsMapper : Mapper<StandingsDto, StandingsEntity> {
    override fun map(input: StandingsDto): StandingsEntity {
        return StandingsEntity(
            id = 0,
            leagueId = input.league?.id!!,
            season= input.league.season!!,
            teamId = input?.response?.get(0)?.league?.standings?.get(0) .team!!.id!!,
            rank = input.rank!!,
            teamName = input.team.name.toString(),
            teamLogoUrl = input.team.logo.toString(),
            points = input.points!!,
            win = input.all?.win!!,
            played = input.all.played!!,
        )


    }
    fun test()()
}