package com.pancake.footballfever.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pancake.footballfever.data.local.database.daos.FootballDao
import com.pancake.footballfever.data.local.database.daos.LeagueDao
import com.pancake.footballfever.data.local.database.daos.PlayerDao
import com.pancake.footballfever.data.local.database.daos.TeamDao
import com.pancake.footballfever.data.local.database.entity.CoachEntity
import com.pancake.footballfever.data.local.database.entity.CountryEntity
import com.pancake.footballfever.data.local.database.entity.FavoriteTeamEntity
import com.pancake.footballfever.data.local.database.entity.FixtureEventsEntity
import com.pancake.footballfever.data.local.database.entity.FixtureHomeEntity
import com.pancake.footballfever.data.local.database.entity.LeagueEntity
import com.pancake.footballfever.data.local.database.entity.TopAssistEntity
import com.pancake.footballfever.data.local.database.entity.TopGoalsEntity
import com.pancake.footballfever.data.local.database.entity.VenueEntity


@Database(
    entities = [
        CoachEntity::class,
        CountryEntity::class,
        FavoriteTeamEntity::class,
        FixtureEventsEntity::class,
        FixtureHomeEntity::class,
        LeagueEntity::class,
        TopGoalsEntity::class,
        TopAssistEntity::class,
        VenueEntity::class,
    ],
    version = 1,
)
abstract class FootballDatabase : RoomDatabase() {
    abstract val footballDao: FootballDao
    abstract val playerDao: PlayerDao
    abstract val leagueDao: LeagueDao
    abstract val teamDao :TeamDao
}