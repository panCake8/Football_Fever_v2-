package com.pancake.footballfever.domain.usecase

import com.pancake.footballfever.data.local.database.daos.HeadToHeadDao
import javax.inject.Inject

class DeleteCachedHeadToHeadUseCase @Inject constructor(private val dao: HeadToHeadDao) {

    suspend fun delete() {
        return dao.deleteAllHeadToHeads()

    }
}