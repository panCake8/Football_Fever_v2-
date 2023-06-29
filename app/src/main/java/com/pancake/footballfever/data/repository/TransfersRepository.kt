package com.pancake.footballfever.data.repository.transfersRepo

import com.pancake.footballfever.data.local.database.entity.TransferEntity

interface TransfersRepository {

    suspend fun fetchTransfersAndCache(team: Int) : Result<List<TransferEntity>>

    suspend fun getCachedTransfers() : List<TransferEntity>
}