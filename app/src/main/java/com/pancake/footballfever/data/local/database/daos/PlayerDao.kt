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
    @Query("SELECT * FROM TOP_PLAYERS_GOAL_TABLE")
    suspend fun getAllTopScorers(): List<TopGoalsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopScorer(topGoalsEntity: TopGoalsEntity)
    // endregion

    //region player top Assists
    @Query("SELECT * FROM TOP_PLAYERS_ASSIST_TABLE")
    suspend fun getAllTopAssists(): List<TopAssistEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopAssists(topScorerEntity: TopAssistEntity)
    // endregion
}