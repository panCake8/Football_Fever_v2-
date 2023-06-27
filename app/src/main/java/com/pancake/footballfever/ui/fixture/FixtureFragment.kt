package com.pancake.footballfever.ui.fixture

import android.util.Log
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentFixtureBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.fixture.adapter.FixtureStatsPagerAdapter
import com.pancake.footballfever.ui.fixture.head2head.FragmentMatchHeadToHead
import com.pancake.footballfever.ui.fixture.head2head.uiState.HeadToHeadUiEvent
import com.pancake.footballfever.ui.fixture.stats.FragmentFixtureStats
import com.pancake.footballfever.ui.fixture.summary.FixtureSummaryFragment
import com.pancake.footballfever.ui.league_state.standing.StandingFragment
import com.pancake.footballfever.utilities.collectLast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FixtureFragment : BaseFragment<FragmentFixtureBinding, FixtureViewModel>() {

    private val arguments by navArgs<FixtureFragmentArgs>()

    override val layoutId = R.layout.fragment_fixture

    override val viewModel by viewModels<FixtureViewModel>()

    private val tabItems = listOf(STATS, STANDING, SUMMARY, H2H)

    private lateinit var fixtureStatsPagerAdapter: FixtureStatsPagerAdapter

    private var fixtureId: Int? = null

    override fun setup() {
        fixtureId = arguments.fixtureId

        fixtureId?.let {
            viewModel.fetchFixture(it)
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fixtureUiState.collect { fixtureUiState ->
                val fixture = fixtureUiState.fixture
                if (fixture != null) {
                    initViewPager()
                    initTabLayout()
                    handleEvent()

                }
            }
        }


        binding.refreshButton.setOnClickListener {
            fixtureId?.let {
                viewModel.refreshData(it)
            }
        }
    }

    private fun initViewPager() {
        fixtureStatsPagerAdapter = FixtureStatsPagerAdapter(this)
        addFragmentsToViewPager()
        binding.pager.adapter = fixtureStatsPagerAdapter


    }

    private fun addFragmentsToViewPager() {

        fixtureStatsPagerAdapter.addFragment(FragmentFixtureStats.newInstance(fixtureId))

        fixtureStatsPagerAdapter.addFragment(
            StandingFragment.newInstance(
                viewModel.fixtureUiState.value.fixture?.leagueId,
                viewModel.fixtureUiState.value.fixture?.season,1
            )
        )
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
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = tabItems[position]
            val tabs = binding.tabLayout.getChildAt(0) as ViewGroup
            for (i in 0 until tabs.childCount) {
                val tab = tabs.getChildAt(i)
                val layoutParams = tab.layoutParams as LinearLayout.LayoutParams
                layoutParams.marginEnd = 30
                tab.layoutParams = layoutParams
                binding.tabLayout.requestLayout()
            }
        }.attach()
    }
    private fun handleEvent() {
        collectLast(viewModel.fixtureEvent) {
            it?.getContentIfNotHandled().let { onClick(it) }

        }
    }
    private fun onClick(event: FixtureUiEvent?) {
        when (event) {
            is FixtureUiEvent.ClickTeamHomeLogoEvent -> {
                event.fixtureModel.let {
                    val nav =
                        FixtureFragmentDirections.actionFixtureFragmentToClubTablesFragment(
                            teamId = it.teamHomeId!!,
                            leagueId = it.leagueId!!,
                            season = it.season!!
                        )

                    findNavController().navigate(nav)
                }

            }
            is FixtureUiEvent.ClickTeamAwayLogoEvent -> {
                event.fixtureModel.let {
                    val nav =
                        FixtureFragmentDirections.actionFixtureFragmentToClubTablesFragment(
                            teamId = it.teamAwayId!!,
                            leagueId  = it.leagueId!!,
                            season = it.season!!
                        )

                    findNavController().navigate(nav)
                }

            }

            else -> {}
        }

    }

    companion object {
        private const val STATS = "Stats"
        private const val SUMMARY = "Summary"
        private const val STANDING = "standing"
        private const val TABLE = "Table"
        private const val H2H = "H2H"
    }
}