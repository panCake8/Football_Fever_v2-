package com.pancake.footballfever.ui.league_state.top_score

import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentTopScoreBinding
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
    }


}