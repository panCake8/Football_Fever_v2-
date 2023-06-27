package com.pancake.footballfever.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pancake.footballfever.data.local.database.daos.ClubDao
import com.pancake.footballfever.data.local.database.daos.FixtureSummaryDao
import com.pancake.footballfever.data.local.database.daos.FixtureDao
import com.pancake.footballfever.data.local.database.daos.FootballDao
import com.pancake.footballfever.data.local.database.daos.HeadToHeadDao
import com.pancake.footballfever.data.local.database.daos.LeagueDao
import com.pancake.footballfever.data.local.database.daos.LeagueMatchesDao
import com.pancake.footballfever.data.local.database.daos.PlayerDao
import com.pancake.footballfever.data.local.database.daos.PlayersDao
import com.pancake.footballfever.data.local.database.daos.TeamFixtureDao
import com.pancake.footballfever.data.local.database.daos.TeamDao
import com.pancake.footballfever.data.local.database.daos.TransferDao
import com.pancake.footballfever.data.local.database.entity.ClubEntity
import com.pancake.footballfever.data.local.database.entity.CountryEntity
import com.pancake.footballfever.data.local.database.entity.FavoriteTeamEntity
import com.pancake.footballfever.data.local.database.entity.TeamFixtureEntity
import com.pancake.footballfever.data.local.database.entity.FixtureEntity
import com.pancake.footballfever.data.local.database.entity.FixtureSummaryEntity
import com.pancake.footballfever.data.local.database.entity.FixtureHomeEntity
import com.pancake.footballfever.data.local.database.entity.InjuriesEntity
import com.pancake.footballfever.data.local.database.entity.HeadToHeadEntity
import com.pancake.footballfever.data.local.database.entity.LeagueEntity
import com.pancake.footballfever.data.local.database.entity.PlayerEntity
import com.pancake.footballfever.data.local.database.entity.SearchKeywordEntity
import com.pancake.footballfever.data.local.database.entity.LeagueMatchEntity
import com.pancake.footballfever.data.local.database.entity.StandingsEntity
import com.pancake.footballfever.data.local.database.entity.TopAssistEntity
import com.pancake.footballfever.data.local.database.entity.TopGoalsEntity
import com.pancake.footballfever.data.local.database.entity.TransferEntity
import com.pancake.footballfever.data.local.database.entity.VenueEntity


@Database(
    entities = [
        TransferEntity::class,
        InjuriesEntity::class,
        CountryEntity::class,
        FavoriteTeamEntity::class,
        FixtureSummaryEntity::class,
        FixtureHomeEntity::class,
        LeagueEntity::class,
        TopGoalsEntity::class,
        TopAssistEntity::class,
        VenueEntity::class,
        StandingsEntity::class,
        FixtureEntity::class,
        SearchKeywordEntity::class,
        TeamFixtureEntity::class,
        PlayerEntity::class,
        LeagueMatchEntity::class,
        HeadToHeadEntity::class,
        ClubEntity::class,
    ],
    version = 1,
)
abstract class FootballDatabase : RoomDatabase() {
    abstract val footballDao: FootballDao
    abstract val playerDao: PlayerDao
    abstract val leagueDao: LeagueDao
    abstract val teamDao: TeamDao
    abstract val fixtureDao: FixtureDao
    abstract val leagueMatches: LeagueMatchesDao
    abstract val headToHead: HeadToHeadDao
    abstract val fixtureSummaryDao: FixtureSummaryDao
    abstract val playersDao: PlayersDao
    abstract val teamFixtureEventsDao: TeamFixtureDao
    abstract val clubDao: ClubDao
    abstract val transferDao : TransferDao

}