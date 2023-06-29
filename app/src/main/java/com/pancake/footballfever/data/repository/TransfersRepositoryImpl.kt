package com.pancake.footballfever.data.repository.transfersRepo

import com.example.footboolfever.data.remote.dto.toTransfersEntity
import com.pancake.footballfever.data.local.database.daos.TransferDao
import com.pancake.footballfever.data.local.database.entity.TransferEntity
import com.pancake.footballfever.data.remote.service.ApiService
import java.lang.Exception
import javax.inject.Inject

class TransfersRepositoryImpl @Inject constructor(
    val dao: TransferDao,
    val apiService: ApiService,
) : TransfersRepository {
    override suspend fun fetchTransfersAndCache(team: Int): Result<List<TransferEntity>> {
        return try {
            val response = apiService.getTransfers(team)
            if (response.isSuccessful) {
                response.body()?.response?.let { dao.insertTransfers(it.map { it.toTransfersEntity() }) }
                Result.success(getCachedTransfers())
            } else
                Result.failure(Throwable(response.message().toString()))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getCachedTransfers() = dao.getAllTransfers()
}