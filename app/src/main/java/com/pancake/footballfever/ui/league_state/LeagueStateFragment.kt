package com.pancake.footballfever.ui.league_state

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentLeagueStateBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.league_state.match.MatchFragment
import com.pancake.footballfever.ui.league_state.standing.StandingFragment
import com.pancake.footballfever.ui.league_state.top_assist.TopAssistFragment
import com.pancake.footballfever.ui.league_state.top_score.TopScoreFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeagueStateFragment : BaseFragment<FragmentLeagueStateBinding, LeagueStateViewModel>() {

    private val tabItems = listOf(MATCH, STANDING, TOP_SCORE, TOP_ASSIST)
    private lateinit var leagueStatePagerAdapter: LeagueStatePagerAdapter

    override val layoutId: Int = R.layout.fragment_league_state
    override val viewModel: LeagueStateViewModel by viewModels()

    private val args: LeagueStateFragmentArgs by navArgs()

    override fun setup() {
        initViewPager()
        initTabLayout()
        initData()
    }

    private fun initData() {
        viewModel.getLeague(args.id)
    }

    private fun initViewPager() {
        leagueStatePagerAdapter = LeagueStatePagerAdapter(this)
        addFragmentToViewPager()
        binding.pager.adapter = leagueStatePagerAdapter
    }

    private fun addFragmentToViewPager() {

        leagueStatePagerAdapter.addFragment(MatchFragment())
        leagueStatePagerAdapter.addFragment(StandingFragment())
        leagueStatePagerAdapter.addFragment(TopScoreFragment())
        leagueStatePagerAdapter.addFragment(TopAssistFragment())

    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = tabItems[position]
        }.attach()
    }

    companion object {
        private const val MATCH = "Match"
        private const val TOP_SCORE = "Top Score"
        private const val STANDING = "Standing"
        private const val TOP_ASSIST = "Top Assist"
    }


}