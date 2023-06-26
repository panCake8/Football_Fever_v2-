package com.pancake.footballfever.data.local.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.footballfever.data.local.database.entity.PlayerEntity

@Dao
interface PlayersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayers(players: List<PlayerEntity>)

    @Query("SELECT * FROM PLAYER_TABLE WHERE season = :seasonId AND teamId = :teamId ORDER BY goals DESC")
    suspend fun getPlayers(seasonId: Int, teamId: Int): List<PlayerEntity>

}