package com.pancake.footballfever.data.local.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.footballfever.data.local.database.entity.FavoriteTeamEntity

@Dao
interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoriteTeam(team: List<FavoriteTeamEntity>)

    @Query("select * from FAVORITE_TEAM_TABLE")
    suspend fun getAllFavoriteTeams(): List<FavoriteTeamEntity>



    @Query("delete from FAVORITE_TEAM_TABLE where id = :teamId")
    suspend fun deleteFavoriteTeam(teamId:Int)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoriteOneTeam(team: FavoriteTeamEntity)
}