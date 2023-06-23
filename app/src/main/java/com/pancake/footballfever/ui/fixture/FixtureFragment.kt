package com.pancake.footballfever.ui.fixture

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentFixtureBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.fixture.adapter.FixtureStatsPagerAdapter
import com.pancake.footballfever.ui.fixture.head2head.FragmentMatchHeadToHead
import com.pancake.footballfever.ui.fixture.stats.FragmentFixtureStats
import com.pancake.footballfever.ui.fixture.summary.FixtureSummaryFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FixtureFragment : BaseFragment<FragmentFixtureBinding, FixtureViewModel>() {

    private val arguments by navArgs<FixtureFragmentArgs>()

    override val layoutId = R.layout.fragment_fixture

    override val viewModel by viewModels<FixtureViewModel>()

    private val tabItems = listOf(STATS, SUMMARY, H2H)

    private lateinit var fixtureStatsPagerAdapter: FixtureStatsPagerAdapter

    private var fixtureId: Int? = null

    override fun setup() {
        fixtureId = arguments.fixtureId
        initViewPager()
        initTabLayout()
        fixtureId?.let {
            viewModel.fetchFixture(it)
        }

    }

    private fun initViewPager() {
        fixtureStatsPagerAdapter = FixtureStatsPagerAdapter(this)
        addFragmentsToViewPager()
        binding.pager.adapter = fixtureStatsPagerAdapter
    }

    private fun addFragmentsToViewPager() {
        fixtureStatsPagerAdapter.addFragment(FragmentFixtureStats.newInstance(239625))
        fixtureStatsPagerAdapter.addFragment(
            FixtureSummaryFragment.newInstance(
                fixtureId,
                viewModel.fixtureUiState.value.fixture?.teamHomeId
            )
        )
        fixtureStatsPagerAdapter.addFragment(
            FragmentMatchHeadToHead.newInstance(
                "${viewModel.fixtureUiState.value.fixture?.teamHomeId}" +
                        "-" +
                        "${viewModel.fixtureUiState.value.fixture?.teamAwayId}"
            )
        )
//        fixtureStatsPagerAdapter.addFragment(FragmentFixtureLineup.newInstance(fixtureId))
//        fixtureStatsPagerAdapter.addFragment(FragmentFixtureLineup.newInstance(fixtureId))
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = tabItems[position]
        }.attach()
    }

    companion object {
        private const val STATS = "Stats"
        private const val SUMMARY = "Summary"
        private const val LINEUP = "Lineup"
        private const val TABLE = "Table"
        private const val H2H = "H2H"
    }
}