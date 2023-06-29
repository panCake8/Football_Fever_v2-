package com.pancake.footballfever.domain.usecases.transferUseCase

import com.pancake.footballfever.data.repository.transfersRepo.TransfersRepository
import javax.inject.Inject

class FetchTransfersUseCase @Inject constructor(
    private val transfersRepository: TransfersRepository
) {
    suspend operator fun invoke() = transfersRepository.fetchTransfersAndCache(33)
}