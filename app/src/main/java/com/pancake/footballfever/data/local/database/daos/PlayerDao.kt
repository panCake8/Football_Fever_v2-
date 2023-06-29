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
    @Query("SELECT * FROM TOP_PLAYERS_GOAL_TABLE WHERE season = :seasonId AND leagueId = :leagueId ORDER BY totalGoals DESC")
    suspend fun getAllTopScorers(leagueId: Int, seasonId: Int): List<TopGoalsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopScorer(topGoalsEntity: List<TopGoalsEntity>)

    @Query("delete from TOP_PLAYERS_GOAL_TABLE  WHERE season = :seasonId AND leagueId = :leagueId ")
    suspend fun deleteAllTopGoals(leagueId: Int, seasonId: Int)
    // endregion

    //region player top Assists
    @Query("SELECT * FROM TOP_PLAYERS_ASSIST_TABLE WHERE season = :seasonId AND leagueId = :leagueId ORDER BY totalAssists DESC")
    suspend fun getAllTopAssists(leagueId: Int, seasonId: Int): List<TopAssistEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopAssists(topScorerEntity: List<TopAssistEntity>)

    @Query("delete from TOP_PLAYERS_ASSIST_TABLE  WHERE season = :seasonId AND leagueId = :leagueId ")
    suspend fun deleteAllTopAssist(leagueId: Int, seasonId: Int)

    // endregion
}