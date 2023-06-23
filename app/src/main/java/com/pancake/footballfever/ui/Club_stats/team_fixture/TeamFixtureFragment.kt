package com.pancake.footballfever.ui.club_stats.team_fixture

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentTeamFixturesBinding
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

private const val SEASON_ARG = "season_arg"
private const val TEAM_ARG = "team_arg"

@AndroidEntryPoint
class TeamFixtureFragment private constructor() : BaseFragment<FragmentTeamFixturesBinding, TeamFixturesViewModel>() {
    override val layoutId = R.layout.fragment_team_fixtures
    override val viewModel: TeamFixturesViewModel by viewModels()

    override fun setup() {
        val season = requireArguments().getString(SEASON_ARG)!!
        val team = requireArguments().getString(TEAM_ARG)!!
        viewModel.getFixtures(season, team)
        val adapter = TeamFixtureAdapter(viewModel)
        binding.rv.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance(season: String, team: String) =
            TeamFixtureFragment().apply {
                arguments = Bundle().apply {
                    putString(SEASON_ARG, season)
                    putString(TEAM_ARG, team)
                }
            }
    }


}