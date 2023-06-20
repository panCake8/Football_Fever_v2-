package com.pancake.footballfever.ui.fixture

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentFixtureBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.fixture.lineup.FragmentFixtureLineup
import com.pancake.footballfever.ui.fixture.stats.FragmentFixtureStats
import dagger.hilt.android.AndroidEntryPoint

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


    companion object {
        private const val STATS = "Stats"
        private const val SUMMARY = "Summary"
        private const val LINEUP = "Lineup"
        private const val TABLE = "Table"
        private const val H2H = "H2H"
    }
}