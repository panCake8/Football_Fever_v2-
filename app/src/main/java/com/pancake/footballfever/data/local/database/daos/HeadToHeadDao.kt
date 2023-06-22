package com.pancake.footballfever.data.local.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.footballfever.data.local.database.entity.HeadToHeadEntity


@Dao
interface HeadToHeadDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHeadToHeads(HeadToHeads: List<HeadToHeadEntity>?)


    @Query("select * from HEAD_TO_HEAD_TABLE")
    suspend fun getAllHeadToHeads(): List<HeadToHeadEntity>

    @Query("delete from HEAD_TO_HEAD_TABLE")
    suspend fun deleteAllHeadToHeads()

}