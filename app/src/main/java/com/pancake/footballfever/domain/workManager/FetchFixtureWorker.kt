package com.pancake.footballfever.domain.workManager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.pancake.footballfever.domain.Constants
import com.pancake.footballfever.domain.usecases.fixutreUseCases.FetchAndCacheFixtureUseCase
import javax.inject.Inject

class FetchFixtureWorker @Inject constructor(
    context: Context,
    params: WorkerParameters,
    private val fetchAndCacheFixtureUseCase: FetchAndCacheFixtureUseCase
) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        val fixtureId = inputData.getInt(Constants.KEY_FIXTURE_ID, 0)
        val fetchDataResult = fetchAndCacheFixtureUseCase(fixtureId)
        return if (fetchDataResult.isSuccess) {
            Result.success()
        } else {
            Result.retry()
        }
    }

}