package com.pancake.footballfever.ui.league_state.top_assist

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentTopAssistBinding
import com.pancake.footballfever.domain.Constants
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.league_state.top_assist.adapter.TopAssistAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TopAssistFragment : BaseFragment<FragmentTopAssistBinding, TopAssistViewModel>() {

    override val layoutId: Int =  R.layout.fragment_top_assist
    override val viewModel: TopAssistViewModel by viewModels()

    override fun setup() {
        super.setup()

        val adapter = TopAssistAdapter(viewModel)
        binding.recyclerViewAssist.adapter = adapter

        val leagueId = requireArguments().getInt(Constants.LEAGUE_ID)
        val season = requireArguments().getInt(Constants.SEASON)

        viewModel.fetchData(leagueId, season)
    }

    companion object {
        @JvmStatic
        fun newInstance(leagueId: Int?, season: Int?): TopAssistFragment {
            val fragment = TopAssistFragment()
            val args = Bundle().apply {
                leagueId?.let { putInt(Constants.LEAGUE_ID, it) }
                season?.let { putInt(Constants.SEASON, it) }
            }
            fragment.arguments = args
            return fragment
        }
    }

}