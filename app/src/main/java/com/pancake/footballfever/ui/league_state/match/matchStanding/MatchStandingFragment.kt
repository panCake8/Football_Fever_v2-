package com.pancake.footballfever.ui.league_state.match.matchStanding

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentMatchStandingBinding
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

private const val HOME_TEAM_ID = "homeTeamId"
private const val AWAY_TEAM_ID = "awayTeamId"
private const val SEASON = "season"
@AndroidEntryPoint
class MatchStandingFragment : BaseFragment<FragmentMatchStandingBinding, MatchStandingViewModel>() {
    override val layoutId = R.layout.fragment_match_standing
    override val viewModel: MatchStandingViewModel by viewModels()
    private var homeTeamId: Int? = null
    private var awayTeamId: Int? = null
    private var season: Int? = null
    override fun setup() {
        super.setup()

        val adapter = MatchStandingAdapter(viewModel)
        binding.recyclerStandingLeague.adapter = adapter

    }

    companion object {

        @JvmStatic
        fun newInstance(homeTeamId: Int, awayTeamId: Int, season: Int) =
            MatchStandingFragment().apply {
                arguments = Bundle().apply {
                    putInt(HOME_TEAM_ID,homeTeamId)
                    putInt(AWAY_TEAM_ID,awayTeamId)
                    putInt(SEASON,season)
                }
            }
    }
}

