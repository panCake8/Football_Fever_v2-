package com.pancake.footballfever.ui.league_state.standing


import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentStandingBinding
import com.pancake.footballfever.domain.Constants
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.club_stats.ClubStatsFragmentDirections
import com.pancake.footballfever.ui.fixture.FixtureFragmentDirections
import com.pancake.footballfever.ui.league_state.LeagueStateFragmentDirections
import com.pancake.footballfever.utilities.EventObserver

import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StandingFragment : BaseFragment<FragmentStandingBinding, StandingsViewModel>() {
    override val layoutId = R.layout.fragment_standing
    override val viewModel: StandingsViewModel by viewModels()
    override fun setup() {
        super.setup()

        val adapter = StandingsAdapter(viewModel)
        binding.recyclerStandingLeague.adapter = adapter

        val leagueId = requireArguments().getInt(Constants.LEAGUE_ID)
        val season = requireArguments().getInt(Constants.SEASON)
        val choose = requireArguments().getInt("choose")
        viewModel.fetchData(leagueId, season)
        observeEvents(choose)

    }
    private fun observeEvents(choose: Int) {
        when(choose){
            1->viewModel.standingEvent.observe(viewLifecycleOwner, EventObserver {
                val nav = FixtureFragmentDirections.actionFixtureFragmentToClubTablesFragment(
                    it.teamId!!,
                    0,
                    it.season!!
                )
                findNavController().navigate(nav)
            })
            2->viewModel.standingEvent.observe(viewLifecycleOwner, EventObserver {
                val nav = LeagueStateFragmentDirections.actionLeagueStateFragmentToClubFragment(
                    it.teamId!!,
                    0,
                    it.season!!
                )
                findNavController().navigate(nav)
            })
            3->viewModel.standingEvent.observe(viewLifecycleOwner, EventObserver {
                val nav = ClubStatsFragmentDirections.actionClubFragmentSelf(
                    it.teamId!!,
                    0,
                    it.season!!
                )
                findNavController().navigate(nav)
            })
        }


    }


    companion object {
        @JvmStatic
         fun newInstance(leagueId: Int?, season: Int?,choose:Int): StandingFragment {
            val fragment = StandingFragment()
            val args = Bundle().apply {
                leagueId?.let { putInt(Constants.LEAGUE_ID, it) }
                season?.let { putInt(Constants.SEASON, it) }
                choose.let { putInt("choose",it) }
            }
            fragment.arguments = args
            return fragment
        }
    }

}