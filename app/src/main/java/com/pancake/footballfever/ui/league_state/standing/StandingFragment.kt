package com.pancake.footballfever.ui.league_state.standing


import android.os.Bundle
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentStandingBinding
import com.pancake.footballfever.domain.Constants
import com.pancake.footballfever.ui.base.BaseFragment

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

        viewModel.fetchData(leagueId, season)
    }

    companion object {
        @JvmStatic
        fun newInstance(leagueId: Int?, season: Int?): StandingFragment {
            val fragment = StandingFragment()
            val args = Bundle().apply {
                leagueId?.let { putInt(Constants.LEAGUE_ID, it) }
                season?.let { putInt(Constants.SEASON, it) }
            }
            fragment.arguments = args
            return fragment
        }
    }

}