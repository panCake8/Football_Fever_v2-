package com.pancake.footballfever.data.local.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.footballfever.data.local.database.entity.TransferEntity

@Dao
interface TransferDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransfers(transfers: List<TransferEntity>)

    @Query("SELECT * FROM TRANSFER_TABLE")
    suspend fun getAllTransfers(): List<TransferEntity>
}