package com.pancake.footballfever.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pancake.footballfever.data.local.database.daos.FootballDao


@Database(
    entities = [

    ],
    version = 1,
)
abstract class FootballDatabase: RoomDatabase() {
    abstract val footballDao: FootballDao
}