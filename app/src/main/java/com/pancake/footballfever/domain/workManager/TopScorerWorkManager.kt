package com.pancake.footballfever.domain.workManager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.pancake.footballfever.domain.usecases.topScorerUsecase.FetchTopGoalsUseCase
import javax.inject.Inject


class TopScorerWorkManager @Inject constructor(
    context: Context,
    params: WorkerParameters,
    private val fetchTopGoalsUseCase: FetchTopGoalsUseCase,
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return try {
            val league = inputData.getInt("league", 39)
            val season = inputData.getInt("season", 2022)

            fetchTopGoalsUseCase(league, season)

            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }

}