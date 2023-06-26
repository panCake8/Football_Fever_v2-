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

    @Query("SELECT * FROM LEAGUE_TABLE")
    fun getAllLeagues(): List<LeagueEntity>

    @Query("delete from LEAGUE_TABLE ")
    suspend fun deleteAllLeagues()


    @Query("SELECT * FROM LEAGUE_TABLE WHERE id = :id")
    fun getLeagueById(id: Int): LeagueEntity?

    @Query("SELECT * FROM LEAGUE_TABLE WHERE name LIKE '%' || :name || '%'")
    fun searchLeaguesByName(name: String): List<LeagueEntity>?

}