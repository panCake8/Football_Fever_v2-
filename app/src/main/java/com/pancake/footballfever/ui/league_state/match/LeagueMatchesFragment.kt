package com.pancake.footballfever.ui.league_state.match

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentLeagueMatchBinding
import com.pancake.footballfever.domain.Constants
import com.pancake.footballfever.ui.base.BaseFragment
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
    }

    private fun setRecycler() {
        binding.viewModel = viewModel
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