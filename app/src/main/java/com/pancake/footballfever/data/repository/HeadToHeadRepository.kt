package com.pancake.footballfever.data.repository

import com.example.footboolfever.data.remote.dto.HeadToHeadDto
import com.pancake.footballfever.data.local.database.entity.HeadToHeadEntity

interface HeadToHeadRepository {

    suspend fun fetchHeadToHeads(h2h: String): List<HeadToHeadDto>?

    suspend fun cacheHeadToHeads(h2h: List<HeadToHeadEntity>)

    suspend fun getCachedHeadToHeads(): List<HeadToHeadEntity>

    suspend fun deleteAllHeadToHeads()
}