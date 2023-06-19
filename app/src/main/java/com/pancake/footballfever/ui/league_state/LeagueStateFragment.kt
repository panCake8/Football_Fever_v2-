package com.pancake.footballfever.ui.league_state

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentLeagueStateBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.league_state.match.MatchFragment
import com.pancake.footballfever.ui.league_state.standing.StandingFragment
import com.pancake.footballfever.ui.league_state.top_assist.TopAssistFragment
import com.pancake.footballfever.ui.league_state.top_score.TopScoreFragment


class LeagueStateFragment : BaseFragment<FragmentLeagueStateBinding, LeagueStateViewModel>() {

    private val tabItems = listOf(MATCH, STANDING, TOP_SCORE, TOP_ASSIST)
    private lateinit var leagueStatePagerAdapter: LeagueStatePagerAdapter

    override val layoutId: Int = R.layout.fragment_league_state
    override val viewModel: LeagueStateViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewPager()
        initTabLayout()
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