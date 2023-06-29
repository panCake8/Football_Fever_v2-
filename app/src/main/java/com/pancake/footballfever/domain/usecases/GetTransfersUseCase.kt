package com.pancake.footballfever.domain.usecases.transferUseCase

import com.pancake.footballfever.data.local.database.entity.toTransferModel
import com.pancake.footballfever.data.repository.transfersRepo.TransfersRepository
import javax.inject.Inject

class GetTransfersUseCase @Inject constructor(
    private val transfersRepository: TransfersRepository
) {
    suspend operator fun invoke() = transfersRepository.getCachedTransfers().map {
        it.toTransferModel()
    }
}