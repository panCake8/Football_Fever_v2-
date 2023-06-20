package com.pancake.footballfever.domain.workManager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.pancake.footballfever.domain.Constants
import com.pancake.footballfever.domain.usecases.fixutreUseCases.FetchAndCacheFixtureUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class FetchFixtureWorker @Inject constructor(
    private val context: Context,
    private val params: WorkerParameters,
    private val fetchAndCacheFixtureUseCase: FetchAndCacheFixtureUseCase
) : Worker(context, params) {
    override fun doWork(): Result {
        val fixtureId = inputData.getInt(Constants.KEY_FIXTURE_ID, 0)
        val fetchDataResult = runBlocking(Dispatchers.IO) {
            fetchAndCacheFixtureUseCase(fixtureId)
        }
        return if (fetchDataResult.isSuccess) {
            Result.success()
        } else {
            Result.retry()
        }
    }

}