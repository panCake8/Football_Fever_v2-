package com.pancake.footballfever.data.local.database.daos

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.footballfever.data.local.database.entity.TeamEntity

interface teamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(team: TeamEntity)

    @Query("SELECT * FROM TEAM_TABLE ORDER BY teamId DESC")
    fun getTeam(): TeamEntity
}