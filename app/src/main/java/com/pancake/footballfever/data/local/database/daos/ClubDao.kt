package com.pancake.footballfever.data.local.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.footballfever.data.local.database.entity.ClubEntity
@Dao
interface ClubDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(team: ClubEntity)

    @Query("SELECT * FROM TEAM_TABLE ")
    suspend fun getTeam(): ClubEntity
    @Query("DELETE FROM TEAM_TABLE")
    suspend fun deleteTeam()
}