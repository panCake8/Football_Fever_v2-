package com.pancake.footballfever.ui.club_stats

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentClubBinding
import com.pancake.footballfever.domain.models.ClubModel
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.fixture.lineup.FragmentFixtureLineup
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ClubStatsFragment :BaseFragment<FragmentClubBinding, ClubViewModel>() {
    private val tabItems = listOf(OVER_VIEW, PLAYERS, MATCHES, TABLE)
    private lateinit var clubStatsPagerAdapter: ClubStatsPagerAdapter
    override val layoutId: Int = R.layout.fragment_club
    override val viewModel: ClubViewModel by viewModels()
    val argument : ClubStatsFragmentArgs by navArgs()
    override fun setup() {
        super.setup()
        viewModel.clubUiEvent.onEach {
            when (it){
                is ClubUiEvent.OnClickFollow -> {
                    binding.followButton.setOnClickListener {
                    if (binding.followButton.text =="follow") {
                        viewModel.addFavoriteOneTeam()
                        binding.followButton.text = "unfollow"
                    }}
                }

                is ClubUiEvent.OnClickUnFollow ->{
                    binding.followButton.setOnClickListener{
                if (binding.followButton.text =="unfollow") {
                    viewModel.deleteFavoriteOneTeam(33)
                    binding.followButton.text = "follow"}
                }
            }}
        }.flowWithLifecycle(lifecycle).launchIn(viewLifecycleOwner.lifecycleScope)
        initViewPager()
        initTabLayout()
    }
    private fun initViewPager() {
        clubStatsPagerAdapter = ClubStatsPagerAdapter(this)
        addFragmentsToViewPager()
        binding.pager.adapter = clubStatsPagerAdapter
    }
    private fun addFragmentsToViewPager() {
//        clubStatsPagerAdapter.addFragment()
//        clubStatsPagerAdapter.addFragment()
//        clubStatsPagerAdapter.addFragment()
//        clubStatsPagerAdapter.addFragment()
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
