package com.pancake.footballfever.data.local.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.footballfever.data.local.database.entity.FixtureEntity

@Dao
interface FixtureDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFixture(fixtures: List<FixtureEntity>)

    @Query("SELECT * FROM FIXTURE_TABLE ORDER BY id DESC")
    suspend fun getFixtures(): List<FixtureEntity>
}