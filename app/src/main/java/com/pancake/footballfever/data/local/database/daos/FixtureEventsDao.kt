package com.pancake.footballfever.data.local.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.footballfever.data.local.database.entity.FixtureEventsEntity

@Dao
interface FixtureEventsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFixtureEvents(fixtureEvents: List<FixtureEventsEntity>)

    @Query("SELECT * FROM FIXTURE_EVENT_TABLE WHERE fixtureId = :fixtureId ORDER BY time ASC")
    suspend fun getFixtureEvents(fixtureId: String) : List<FixtureEventsEntity>

}