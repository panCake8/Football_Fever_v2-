package com.pancake.footballfever.data.local.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footboolfever.data.local.database.entity.TopAssistEntity
import com.example.footboolfever.data.local.database.entity.TopScorerEntity

@Dao
interface PlayerDao {

    //region player top scorer
    @Query("SELECT * FROM TOP_SCORER")
    suspend fun getAllTopScorers(): List<TopScorerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopScorer(topScorerEntity: TopScorerEntity)
    // endregion

    //region player top Assists
    @Query("SELECT * FROM TOP_ASSIST")
    suspend fun getAllTopAssists(): List<TopAssistEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopAssists(topScorerEntity: TopAssistEntity)
    // endregion
}