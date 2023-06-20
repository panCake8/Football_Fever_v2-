package com.pancake.footballfever.ui.coach

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentCoachBinding
import com.pancake.footballfever.domain.workmanager.FetchCoachesWorker
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.coach.adapter.CoachAdapter
import com.pancake.footballfever.ui.selectCountry.adapter.SelectCountryAdapter
import java.util.concurrent.TimeUnit


class CoachFragment : BaseFragment<FragmentCoachBinding,CoachViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_coach

    override val viewModel: CoachViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        schedule(requireContext())
    }


    private fun setupRecyclerView() {
        binding.coachesRecycler.adapter = CoachAdapter(viewModel)
    }

    companion object {
        fun schedule(context: Context) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val request = PeriodicWorkRequestBuilder<FetchCoachesWorker>(1, TimeUnit.DAYS)
                .setConstraints(constraints)
                .build()

            WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                "fetchCoachesWorker",
                ExistingPeriodicWorkPolicy.KEEP,
                request,
            )
        }
    }


}