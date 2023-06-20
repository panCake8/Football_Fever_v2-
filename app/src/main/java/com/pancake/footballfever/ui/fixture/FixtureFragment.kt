package com.pancake.footballfever.ui.fixture

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.google.android.material.tabs.TabLayoutMediator
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentFixtureBinding
import com.pancake.footballfever.domain.Constants
import com.pancake.footballfever.domain.workManager.FetchFixtureWorker
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.fixture.lineup.FragmentFixtureLineup
import com.pancake.footballfever.ui.fixture.stats.FragmentFixtureStats
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class FixtureFragment : BaseFragment<FragmentFixtureBinding, FixtureViewModel>() {

    private val arguments by navArgs<FixtureFragmentArgs>()

    override val layoutId = R.layout.fragment_fixture

    override val viewModel by activityViewModels<FixtureViewModel>()

    private val tabItems = listOf(STATS, SUMMARY, LINEUP, TABLE, H2H)

    private lateinit var fixtureStatsPagerAdapter: FixtureStatsPagerAdapter

    private var fixtureId: Int? = null

    override fun setup() {
        fixtureId = arguments.fixtureId
        initViewPager()
        initTabLayout()
        initWorkManager(fixtureId)
    }

    private fun initViewPager() {
        fixtureStatsPagerAdapter = FixtureStatsPagerAdapter(this)
        addFragmentsToViewPager()
        binding.pager.adapter = fixtureStatsPagerAdapter
    }

    private fun addFragmentsToViewPager() {
        fixtureStatsPagerAdapter.addFragment(FragmentFixtureLineup.newInstance(fixtureId))
        fixtureStatsPagerAdapter.addFragment(FragmentFixtureStats.newInstance(fixtureId))
        fixtureStatsPagerAdapter.addFragment(FragmentFixtureLineup.newInstance(fixtureId))
        fixtureStatsPagerAdapter.addFragment(FragmentFixtureLineup.newInstance(fixtureId))
        fixtureStatsPagerAdapter.addFragment(FragmentFixtureLineup.newInstance(fixtureId))
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = tabItems[position]
        }.attach()
    }


    private fun initWorkManager(fixtureId: Int?) {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val inputData = fixtureId?.let {
            Data.Builder()
                .putInt(Constants.KEY_FIXTURE_ID, 239625)
                .build()
        }
        val request = inputData?.let {
            PeriodicWorkRequestBuilder<FetchFixtureWorker>(16, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .setInputData(it)
                .build()
        }
        request?.let {
            WorkManager.getInstance(requireContext()).enqueueUniquePeriodicWork(
                FIXTURE_WORK_MANAGER,
                ExistingPeriodicWorkPolicy.KEEP,
                it
            )
        }

    }


    companion object {
        private const val STATS = "Stats"
        private const val SUMMARY = "Summary"
        private const val LINEUP = "Lineup"
        private const val TABLE = "Table"
        private const val H2H = "H2H"
        private const val FIXTURE_WORK_MANAGER = "fixtureWorkManager"
    }
}