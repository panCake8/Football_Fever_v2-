package com.pancake.footballfever.data.local.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.footballfever.data.local.database.entity.TopAssistEntity
import com.pancake.footballfever.data.local.database.entity.TopGoalsEntity

@Dao
interface PlayerDao {

    //region player top scorer
    @Query("SELECT * FROM TOP_PLAYERS_GOAL_TABLE ORDER BY totalGoals DESC")
    suspend fun getAllTopScorers(): List<TopGoalsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopScorer(topGoalsEntity: List<TopGoalsEntity>)

    @Query("delete from TOP_PLAYERS_GOAL_TABLE ")
    suspend fun deleteAllTopGoals()
    // endregion

    //region player top Assists
    @Query("SELECT * FROM TOP_PLAYERS_ASSIST_TABLE ORDER BY totalAssists DESC")
    suspend fun getAllTopAssists(): List<TopAssistEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopAssists(topScorerEntity: List<TopAssistEntity>)

    @Query("delete from TOP_PLAYERS_ASSIST_TABLE ")
    suspend fun deleteAllTopAssist()

    // endregion
}