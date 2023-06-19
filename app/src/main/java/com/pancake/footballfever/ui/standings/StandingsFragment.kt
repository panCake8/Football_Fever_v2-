package com.pancake.footballfever.ui.standings

import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentStandingsBinding
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StandingsFragment : BaseFragment<FragmentStandingsBinding, StandingsViewModel>() {
    override val layoutId = R.layout.fragment_standings
    override val viewModel: StandingsViewModel by viewModels()
    override fun setup() {
        super.setup()

        val adapter = StandingsAdapter(viewModel)
        binding.recyclerStandingLeague.adapter = adapter
    }


}