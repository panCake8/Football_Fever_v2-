package com.pancake.footballfever.ui.league_state.standing


import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentStandingBinding
import com.pancake.footballfever.ui.base.BaseFragment
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
        observeEvent()


    }
    private fun observeEvent() {
        viewModel.standingEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =LeagueStateFragmentDirections.actionLeagueStateFragmentToClubTablesFragment(it.teamId!!,it.season!!)

            findNavController().navigate(nav)
        })
    }



}