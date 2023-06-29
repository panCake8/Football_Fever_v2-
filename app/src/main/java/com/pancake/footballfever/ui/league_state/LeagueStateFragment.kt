package com.pancake.footballfever.ui.league_state

import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentLeagueStateBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.league_state.match.LeagueMatchesFragment
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

        leagueStatePagerAdapter.addFragment(LeagueMatchesFragment.newInstance(args.id, args.season))
        leagueStatePagerAdapter.addFragment(StandingFragment.newInstance(args.id, args.season,2))
        leagueStatePagerAdapter.addFragment(TopScoreFragment.newInstance(args.id, args.season))
        leagueStatePagerAdapter.addFragment(TopAssistFragment.newInstance(args.id, args.season))

    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = tabItems[position]
            val tabs = binding.tabLayout.getChildAt(0) as ViewGroup
            for (i in 0 until tabs.childCount) {
                val tab = tabs.getChildAt(i)
                val layoutParams = tab.layoutParams as LinearLayout.LayoutParams
                layoutParams.marginEnd = 30
                tab.layoutParams = layoutParams
                binding.tabLayout.requestLayout()
            }
        }.attach()
    }

    companion object {
        private const val MATCH = "Match"
        private const val TOP_SCORE = "Top Score"
        private const val STANDING = "Standing"
        private const val TOP_ASSIST = "Top Passes"
    }


}