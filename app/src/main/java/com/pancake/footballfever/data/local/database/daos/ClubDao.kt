package com.pancake.footballfever.data.local.database.daos

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.footballfever.data.local.database.entity.TeamEntity

interface ClubDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(team: TeamEntity)

    @Query("SELECT * FROM TEAM_TABLE ")
    fun getTeam(): TeamEntity
}