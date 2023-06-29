package com.pancake.footballfever.ui.league_state.match

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentLeagueMatchBinding
import com.pancake.footballfever.domain.Constants
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.league_state.LeagueStateFragmentDirections
import com.pancake.footballfever.ui.league_state.match.adapter.LeagueMatchesParentAdapter
import com.pancake.footballfever.ui.league_state.match.uiState.LeagueMatchUiEvent
import com.pancake.footballfever.utilities.collectLast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeagueMatchesFragment : BaseFragment<FragmentLeagueMatchBinding, LeagueMatchesViewModel>() {


    override val layoutId: Int
        get() = R.layout.fragment_league_match

    override val viewModel: LeagueMatchesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setRecycler()
        val leagueId = requireArguments().getInt(Constants.LEAGUE_ID)
        val season = requireArguments().getInt(Constants.SEASON)

        viewModel.getAllLeagueMatches(season, leagueId)

        binding.refreshButton.setOnClickListener {
            viewModel.refreshData(season, leagueId)
        }

        setRecycler()
        handleEvent()
    }

    private fun handleEvent() {
        collectLast(viewModel.leagueMatchUiEvent) {

            onClick(it?.getContentIfNotHandled())
        }

    }

    private fun onClick(event: LeagueMatchUiEvent?) {
        when (event) {
            is LeagueMatchUiEvent.LeagueMatchClickEvent -> {
                event.match.let {
                    val nav = LeagueStateFragmentDirections.actionLeagueStateFragmentToFixtureFragment(
                        fixtureId = it.id!!,
                        season = it.season!!,
                        date = it.date!!,
                    )
                    findNavController().navigate(nav)
                }

            }

            else -> {}
        }


    }


    private fun setRecycler() {

        binding.parentLeagueMatchRecycler.adapter = LeagueMatchesParentAdapter(viewModel)

    }

    companion object {
        @JvmStatic
        fun newInstance(leagueId: Int?, season: Int?): LeagueMatchesFragment {
            val fragment = LeagueMatchesFragment()
            val args = Bundle().apply {
                leagueId?.let { putInt(Constants.LEAGUE_ID, it) }
                season?.let { putInt(Constants.SEASON, it) }
            }
            fragment.arguments = args
            return fragment
        }
    }

}