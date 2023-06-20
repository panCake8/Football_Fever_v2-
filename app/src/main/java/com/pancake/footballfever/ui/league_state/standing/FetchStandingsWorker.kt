import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.pancake.footballfever.data.repository.StandingsRepositoryImp
import java.util.concurrent.TimeUnit

class FetchStandingsWorker(
    private val context: Context,
    private val params: WorkerParameters,
    private val standingsRepositoryImp: StandingsRepositoryImp

) : Worker(context, params) {

    override  fun doWork(): Result {

//        val fetchDataResult = standingsRepositoryImp.fetchStandingsAndCache(2,2)
//        return if (fetchDataResult is Result.Success) {
//            Result.success()
//        } else {
//            Result.retry()
//        }
      return  Result.success()
    }

    companion object {
        const val WORK_NAME = "FetchStandingsWorker"

        fun schedule(context: Context) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val request = PeriodicWorkRequestBuilder<FetchStandingsWorker>(1, TimeUnit.HOURS)
                .setConstraints(constraints)
                .build()

            WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                WORK_NAME,
                ExistingPeriodicWorkPolicy.KEEP,
                request
            )
        }

        fun cancel(context: Context) {
            WorkManager.getInstance(context).cancelUniqueWork(WORK_NAME)
        }
    }
}
