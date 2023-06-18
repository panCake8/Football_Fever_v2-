package com.pancake.footballfever.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.footboolfever.data.local.database.entity.CountryEntity
import com.example.footboolfever.data.local.database.entity.FavoriteTeamEntity
import com.example.footboolfever.data.local.database.entity.FixtureHomeEntity
import com.example.footboolfever.data.local.database.entity.LeagueEntity
import com.example.footboolfever.data.local.database.entity.VenueEntity
import com.pancake.footballfever.data.local.database.daos.FootballDao


@Database(
    entities = [
        CountryEntity::class,
        LeagueEntity::class,
        VenueEntity::class,
        FavoriteTeamEntity::class,
        FixtureHomeEntity::class
    ],
    version = 1,
)
abstract class FootballDatabase: RoomDatabase() {
    abstract val footballDao: FootballDao
}