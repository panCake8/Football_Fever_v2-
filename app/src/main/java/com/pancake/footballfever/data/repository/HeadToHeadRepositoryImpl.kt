package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.HeadToHeadDto
import com.pancake.footballfever.data.local.database.daos.HeadToHeadDao
import com.pancake.footballfever.data.local.database.entity.HeadToHeadEntity
import com.pancake.footballfever.data.remote.service.ApiService
import javax.inject.Inject

class HeadToHeadRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dao: HeadToHeadDao,
) :
    HeadToHeadRepository {

    override suspend fun fetchHeadToHeads(h2h: String): List<HeadToHeadDto>? =
        apiService.getHeadToHeadFixtures(h2h).body()?.response

    override suspend fun cacheHeadToHeads(h2h: List<HeadToHeadEntity>) =
        dao.addHeadToHeads(h2h)

    override suspend fun getCachedHeadToHeads(): List<HeadToHeadEntity> =
        dao.getAllHeadToHeads()

    override suspend fun deleteAllHeadToHeads() =
        dao.deleteAllHeadToHeads()
}