package com.pancake.footballfever.data.local.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.footballfever.data.local.database.entity.FixtureEntity
import com.pancake.footballfever.data.local.database.entity.FixtureHomeEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

@Dao
interface FixtureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFixtureHome(teams: List<FixtureHomeEntity>)

    @Query("select * from FIXTURE_HOME_TABLE")
    fun getAllFixtureHome(): Flow<List<FixtureHomeEntity>>

    @Query("delete from FIXTURE_HOME_TABLE ")
    suspend fun deleteAllFixtureHome()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFixture(fixtures: List<FixtureEntity>)

    @Query("SELECT * FROM FIXTURE_TABLE ORDER BY id DESC")
    suspend fun getFixtures(): List<FixtureEntity>
}