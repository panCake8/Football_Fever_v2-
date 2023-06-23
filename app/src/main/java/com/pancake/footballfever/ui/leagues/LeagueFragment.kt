package com.pancake.footballfever.ui.leagues

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentLeagueBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.leagues.adapter.LeaguesAdapter
import com.pancake.footballfever.ui.leagues.uiState.LeagueUiEvent

import com.pancake.footballfever.utilities.EventObserver
import com.pancake.footballfever.utilities.collectLast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeagueFragment : BaseFragment<FragmentLeagueBinding, LeaguesViewModel>() {

    override val layoutId: Int = R.layout.fragment_league
    override val viewModel: LeaguesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerAdapter()
        collectEvent()
    }

    private fun setRecyclerAdapter() {
        binding.recyclerLeague.adapter = LeaguesAdapter(viewModel)
    }
    private fun collectEvent() {
        collectLast(viewModel.leagueEvent) {
            it?.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }
    private fun onEvent(event: LeagueUiEvent) {
        when (event) {
            is LeagueUiEvent.ClickLeagueEvent -> {
                val nav =
                    LeagueFragmentDirections.actionLeagueFragmentToLeagueStateFragment(event.league.id!!, event.league.season!!)
                findNavController().navigate(nav)
            }
        }

    }

    override fun showBottomNavBar(show: Boolean) {
        super.showBottomNavBar(true)
    }

}