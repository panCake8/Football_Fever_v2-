package com.pancake.footballfever.ui.player

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentPlayersBinding
import com.pancake.footballfever.domain.models.Player
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayersFragment : BaseFragment<FragmentPlayersBinding, PlayersViewModel>() {
    override val layoutId = R.layout.fragment_players
    override val viewModel: PlayersViewModel by viewModels()
    private val args: PlayersFragmentArgs by navArgs()

    override fun setup() {
        viewModel.getPlayers(args.fixtureId, args.teamId)
        val adapter = PlayersAdapter(object : PlayersAdapter.PlayerClickListener {
            override fun onClick(player: Player) {

            }

        })

        binding.rv.adapter = adapter


    }
}