package com.pancake.footballfever.domain.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.pancake.footballfever.data.repository.ListCoachRepository
import com.pancake.footballfever.domain.usecase.FetchCoachUseCase
import javax.inject.Inject

class FetchCoachesWorker @Inject constructor(
    private val context: Context,
    private val params: WorkerParameters,
    private val coachRepository: ListCoachRepository
) : Worker(context, params) {

    override fun doWork(): Result {
        val fetchDataUseCase = FetchCoachUseCase(coachRepository)
        return Result.success()
    }

}