package com.pancake.footballfever.ui.club_stats

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentClubBinding
import com.pancake.footballfever.domain.models.ClubModel
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.club_stats.player.PlayersFragment
import com.pancake.footballfever.ui.club_stats.team_fixture.TeamFixtureFragment
import com.pancake.footballfever.ui.fixture.lineup.FragmentFixtureLineup
import com.pancake.footballfever.ui.fixture.standing.FragmentFixtureStanding
import com.pancake.footballfever.ui.league_state.standing.StandingFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ClubStatsFragment :BaseFragment<FragmentClubBinding, ClubViewModel>() {
    private val tabItems = listOf(PLAYERS, MATCHES, TABLE)
    private lateinit var clubStatsPagerAdapter: ClubStatsPagerAdapter
    override val layoutId: Int = R.layout.fragment_club
    override val viewModel: ClubViewModel by viewModels()
    val argument : ClubStatsFragmentArgs by navArgs()


    override fun setup() {
        super.setup()
        viewModel.getClub(argument.teamId)
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
                    viewModel.deleteFavoriteOneTeam(argument.teamId)
                    binding.followButton.text = "follow"}
                }
            }

                else -> {
                    TODO()
                }
            }
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
        clubStatsPagerAdapter.addFragment(PlayersFragment.newInstance(argument.seasonId,argument.teamId))
        clubStatsPagerAdapter.addFragment(TeamFixtureFragment.newInstance(argument.seasonId.toString(),argument.teamId.toString()))
//        clubStatsPagerAdapter.addFragment()
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
        private const val PLAYERS = "players"
        private const val MATCHES = "matches"
        private const val TABLE = "Table"
    }

}
