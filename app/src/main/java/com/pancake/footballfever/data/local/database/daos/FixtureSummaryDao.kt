package com.pancake.footballfever.data.local.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.footballfever.data.local.database.entity.FixtureSummaryEntity

@Dao
interface FixtureSummaryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFixtureSummary(fixtureSummaries: List<FixtureSummaryEntity>)

    @Query("SELECT * FROM FIXTURE_SUMMARY_TABLE WHERE fixtureId = :fixtureId ORDER BY time ASC")
    suspend fun getFixtureSummary(fixtureId: Int) : List<FixtureSummaryEntity>

}