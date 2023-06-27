package com.pancake.footballfever.domain.usecase

import com.pancake.footballfever.data.local.database.daos.HeadToHeadDao
import com.pancake.footballfever.data.local.database.entity.HeadToHeadEntity
import javax.inject.Inject

class GetCachedHeadToHeadsUseCase @Inject constructor(
    private val dao: HeadToHeadDao,
) {


    suspend fun getHeadToHeads(): List<HeadToHeadEntity>? {
        return dao.getAllHeadToHeads()

    }
}