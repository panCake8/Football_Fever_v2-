package com.pancake.footballfever.data.local.mappers.leagueMatchMapper

import com.example.footboolfever.data.remote.dto.FixturesDto
import com.pancake.footballfever.data.local.database.entity.LeagueMatchEntity
import com.pancake.footballfever.domain.mappers.Mapper
import com.pancake.footballfever.utilities.toDate

//class LeagueMatchesDtoToLocalMapper : Mapper<FixturesDto, LeagueMatchEntity> {
//    override fun map(input: FixturesDto): LeagueMatchEntity {
//        return LeagueMatchEntity(
//            homeTeamLogo = input.teams?.home?.logo,
//            awayTeamLogo = input.teams?.away?.logo,
//            awayTeamName = input.teams?.away?.name,
//            homeTeamName = input.teams?.home?.name,
//            id = input.fixture?.id,
//            date = input.fixture?.date?.take(10),
//            matchTime = input.fixture?.timestamp?.toDate(),
//            season = input.league?.season,
//        )
//    }


//}