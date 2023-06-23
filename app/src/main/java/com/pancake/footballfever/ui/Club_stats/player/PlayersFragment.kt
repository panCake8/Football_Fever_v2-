package com.pancake.footballfever.ui.club_stats.player

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentPlayersBinding
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

private const val TEAM_ID_ARG = "team_id_arg"
private const val FIXTURE_ID_ARG = "fixture_id_arg"

@AndroidEntryPoint
class PlayersFragment private constructor() : BaseFragment<FragmentPlayersBinding, PlayersViewModel>() {
    override val layoutId = R.layout.fragment_players
    override val viewModel: PlayersViewModel by viewModels()
    override fun setup() {
        val teamId = requireArguments().getString(TEAM_ID_ARG)!!
        val fixtureId = requireArguments().getString(FIXTURE_ID_ARG)!!
        viewModel.getPlayers(fixtureId, teamId)
        val adapter = PlayersAdapter(viewModel)

        binding.rv.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance(fixtureId: String, teamId: String) =
            PlayersFragment().apply {
                arguments = Bundle().apply {
                    putString(FIXTURE_ID_ARG, fixtureId)
                    putString(TEAM_ID_ARG, teamId)
                }
            }
    }

}