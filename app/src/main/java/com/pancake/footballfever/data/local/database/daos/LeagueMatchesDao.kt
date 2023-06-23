package com.pancake.footballfever.data.local.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.footballfever.data.local.database.entity.LeagueMatchEntity

@Dao
interface LeagueMatchesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLeagueMatch(match: List<LeagueMatchEntity>)

    @Query("SELECT * FROM LEAGUE_MATCH_TABLE")
    suspend fun getAllLeagueMatches(): List<LeagueMatchEntity>

    @Query("DELETE FROM LEAGUE_MATCH_TABLE")
    suspend fun deleteAllLeagueMatches()
}