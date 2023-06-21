package com.pancake.footballfever.data.local.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.footballfever.data.local.database.entity.LeagueEntity
@Dao
interface LeagueDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLeagues(leagues: List<LeagueEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertALeagues(leagues: LeagueEntity)

    @Query("SELECT * FROM LEAGUE_TABLE ORDER BY id DESC")
    fun getAllLeagues(): List<LeagueEntity>
}