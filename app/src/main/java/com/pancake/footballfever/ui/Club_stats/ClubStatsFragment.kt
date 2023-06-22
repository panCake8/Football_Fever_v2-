package com.pancake.footballfever.ui.Club_stats

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentClubBinding
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClubStatsFragment :BaseFragment<FragmentClubBinding,ClubViewModel>() {
    private val tabItems = listOf(OVER_VIEW, PLAYERS, MATCHES, TABLE)
    private lateinit var clubStatsPagerAdapter: ClubStatsPagerAdapter
    override val layoutId: Int = R.layout.fragment_club
    override val viewModel: ClubViewModel by viewModels()
    val argument : ClubStatsFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
        initTabLayout()
    }
    private fun initViewPager() {
        clubStatsPagerAdapter = ClubStatsPagerAdapter(this)
        addFragmentsToViewPager()
        binding.pager.adapter = clubStatsPagerAdapter
    }
    private fun addFragmentsToViewPager() {
//        clubStatsPagerAdapter.addFragment(ClubStandingFragment())
//        clubStatsPagerAdapter.addFragment(ClubStandingFragment())
//        clubStatsPagerAdapter.addFragment(ClubStandingFragment())
//        clubStatsPagerAdapter.addFragment(ClubStandingFragment())
    }


    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = tabItems[position]
        }.attach()
    }

    companion object {
        private const val OVER_VIEW = "over view"
        private const val PLAYERS = "players"
        private const val MATCHES = "matches"
        private const val TABLE = "Table"
    }

}
