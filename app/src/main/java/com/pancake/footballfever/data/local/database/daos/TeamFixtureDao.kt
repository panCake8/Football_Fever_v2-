package com.pancake.footballfever.data.local.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.footballfever.data.local.database.entity.FixtureEntity

@Dao
interface TeamFixtureDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFixtures(fixtures: List<FixtureEntity>)

    @Query("SELECT * FROM FIXTURE_TABLE WHERE season = :season AND team = :team ORDER BY timestamp DESC")
    suspend fun getFixtures(season: String,team: String) : List<FixtureEntity>

}