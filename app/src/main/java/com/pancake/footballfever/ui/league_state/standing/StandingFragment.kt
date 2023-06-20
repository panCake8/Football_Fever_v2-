package com.pancake.footballfever.ui.league_state.standing


import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentStandingBinding
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
//        viewModel.fetchData()

    }



//    override fun onDestroy() {
//        super.onDestroy()
//        viewModel.cancelFetchingData()
//    }




}