package com.pancake.footballfever.ui.league_state.top_score

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentTopScoreBinding
import com.pancake.footballfever.domain.Constants
import com.pancake.footballfever.ui.base.BaseFragment

import com.pancake.footballfever.ui.league_state.top_score.adapter.TopScorerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopScoreFragment : BaseFragment<FragmentTopScoreBinding, TopScorerViewModel>() {

    override val layoutId: Int = R.layout.fragment_top_score
    override val viewModel: TopScorerViewModel by viewModels()

    override fun setup() {
        super.setup()

        val adapter = TopScorerAdapter(viewModel)
        binding.recyclerViewScorers.adapter = adapter

        val leagueId = requireArguments().getInt(Constants.LEAGUE_ID)
        val season = requireArguments().getInt(Constants.SEASON)

        viewModel.fetchData(leagueId, season)
    }

    companion object {

        @JvmStatic
        fun newInstance(leagueId: Int?, season: Int?): TopScoreFragment {
            val fragment = TopScoreFragment()
            val args = Bundle().apply {
                leagueId?.let { putInt(Constants.LEAGUE_ID, it) }
                season?.let { putInt(Constants.SEASON, it) }
            }
            fragment.arguments = args
            return fragment
        }
//        fun newInstance(leagueId: Int?, season: Int?) =
//            LeagueStateFragment().apply {
//                arguments = Bundle().apply {
//                    leagueId?.let { putInt(Constants.LEAGUE_ID, it) }
//                    season?.let { putInt(Constants.SEASON, it) }
//                }
//            }
    }
}