package com.pancake.footballfever.data.local.database.daos

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.footballfever.data.local.database.entity.GameLeagueEntity

interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGameLeagues(gameLeagues: List<GameLeagueEntity>?)

    @Query("select * from GAME_LEAGUE_TABLE")
    suspend fun getAllLeagues(): List<GameLeagueEntity>

    @Query("delete from GAME_LEAGUE_TABLE")
    suspend fun deleteAllLeagues()

}