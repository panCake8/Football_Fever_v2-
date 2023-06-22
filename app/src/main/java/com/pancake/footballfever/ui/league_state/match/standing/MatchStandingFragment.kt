package com.pancake.footballfever.ui.league_state.match.standing

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentMatchStandingBinding
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchStandingFragment : BaseFragment<FragmentMatchStandingBinding, MatchStandingViewModel>() {
    override val layoutId = R.layout.fragment_match_standing
    override val viewModel : MatchStandingViewModel by viewModels ()
    private val argument : MatchStandingFragmentArgs by navArgs()
    override fun setup() {
        super.setup()

        val adapter = MatchStandingAdapter(viewModel , argument.homeTeamId, argument.awayTeamId)
        binding.recyclerStandingLeague.adapter = adapter
    }

}