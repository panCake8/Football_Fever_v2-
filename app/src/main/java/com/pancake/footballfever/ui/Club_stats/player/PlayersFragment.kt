package com.pancake.footballfever.ui.club_stats.player

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentPlayersBinding
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

private const val TEAM_ID_ARG = "team_id_arg"
private const val SEASON_ID_ARG = "fixture_id_arg"

@AndroidEntryPoint
class PlayersFragment private constructor() : BaseFragment<FragmentPlayersBinding, PlayersViewModel>() {
    override val layoutId = R.layout.fragment_players
    override val viewModel: PlayersViewModel by viewModels()
    override fun setup() {
        val teamId = requireArguments().getInt(TEAM_ID_ARG)!!
        val seasonId = requireArguments().getInt(SEASON_ID_ARG)!!
        viewModel.getPlayers(seasonId, teamId)
        val adapter = PlayersAdapter(viewModel)

        binding.rv.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance(season: Int, teamId: Int) =
            PlayersFragment().apply {
                arguments = Bundle().apply {
                    putInt(SEASON_ID_ARG, season)
                    putInt(TEAM_ID_ARG, teamId)
                }
            }
    }

}